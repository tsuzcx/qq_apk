package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.i;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends b
{
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> lWb;
  public LinearLayoutManager mmj;
  d nMx;
  
  public e(com.tencent.mm.plugin.choosemsgfile.ui.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(123322);
    this.lWb = new ArrayList();
    AppMethodBeat.o(123322);
  }
  
  public final void b(final boolean paramBoolean, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123324);
    ad.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nMs.iP(paramBoolean);
    if (paramBoolean) {
      this.lWb.clear();
    }
    g.afC();
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123319);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().dG(e.this.flk, -1);
        if (localCursor == null)
        {
          ad.e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
          AppMethodBeat.o(123319);
          return;
        }
        List localList = com.tencent.mm.plugin.choosemsgfile.b.d.c.RH(paramString2);
        long l1 = 0L;
        label390:
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              bl localbl = new bl();
              localbl.convertFrom(localCursor);
              Object localObject2 = localbl.field_content;
              if (localObject2 == null) {
                break label390;
              }
              localObject2 = k.b.rx((String)localObject2);
              if ((localObject2 == null) || (((k.b)localObject2).type != 6)) {
                break label390;
              }
              localObject2 = new com.tencent.mm.plugin.choosemsgfile.b.b.k(e.this.nMx, localbl, e.this.flk);
              if (localList.size() == 0)
              {
                i = 1;
                if (i == 0) {
                  continue;
                }
                localObject3 = new Date(localbl.field_createTime);
                long l2 = com.tencent.mm.ui.gridviewheaders.a.fcX().b((Date)localObject3);
                if (l1 != l2) {
                  localLinkedList.add(new i(e.this.nMx, localbl.field_createTime));
                }
                localLinkedList.add(localObject2);
                l1 = l2;
                break label390;
              }
              Object localObject3 = localList.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                String str = (String)((Iterator)localObject3).next();
                boolean bool = ((com.tencent.mm.plugin.choosemsgfile.b.b.k)localObject2).getFileName().endsWith(str);
                if (!bool) {
                  continue;
                }
                i = 1;
                continue;
              }
            }
            else
            {
              localCursor.close();
              e.this.lWb.addAll(localLinkedList);
              localLinkedList.clear();
              ad.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", new Object[] { Integer.valueOf(e.this.lWb.size()) });
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123318);
                  if (e.this.nMs != null) {
                    e.this.nMs.A(e.2.this.nMD, e.this.lWb.size());
                  }
                  AppMethodBeat.o(123318);
                }
              });
              AppMethodBeat.o(123319);
              return;
            }
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(123319);
          }
          int i = 0;
        }
      }
    });
    AppMethodBeat.o(123324);
  }
  
  public final RecyclerView.a bNK()
  {
    AppMethodBeat.i(123323);
    this.nMx = new d(this.nMs, this.lWb);
    a.nMv = new g.b() {};
    this.nMx.nMu = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.b.b.a paramAnonymousa, final RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(123317);
        if (paramAnonymousa == null)
        {
          ad.e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(123317);
          return;
        }
        ad.i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.bNz();
          e.a(e.this).nS(paramAnonymousa.nLz.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.b.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.b.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123311);
              ad.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              e.a(e.this).nT(paramAnonymousa.nLz.field_msgId);
              e.a(e.this).a(paramAnonymousa.nLz.field_msgId, paramAnonymous2MsgFile);
              if (e.a(e.this).bNM()) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123310);
                    e.this.nMx.aql.notifyChanged();
                    AppMethodBeat.o(123310);
                  }
                });
              }
              e.this.nMs.bNP();
              paramAnonymousa.bNA();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).nMd.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.T(paramAnonymousv);
              }
              AppMethodBeat.o(123311);
            }
            
            public final void bNo()
            {
              AppMethodBeat.i(123312);
              ad.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              e.a(e.this).nT(paramAnonymousa.nLz.field_msgId);
              paramAnonymousa.bNC();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).nMd.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousv);
              }
              AppMethodBeat.o(123312);
            }
            
            public final void bNp()
            {
              AppMethodBeat.i(123313);
              ad.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              e.a(e.this).nT(paramAnonymousa.nLz.field_msgId);
              paramAnonymousa.bND();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).nMd.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousv);
              }
              AppMethodBeat.o(123313);
            }
            
            public final void bNq()
            {
              AppMethodBeat.i(123314);
              ad.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              e.a(e.this).nT(paramAnonymousa.nLz.field_msgId);
              paramAnonymousa.bNB();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).nMd.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousv);
              }
              AppMethodBeat.o(123314);
            }
            
            public final void eP(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123315);
              ad.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.eR(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).nMd.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousv);
              }
              AppMethodBeat.o(123315);
            }
          }, e.this.bNJ());
        }
        for (;;)
        {
          paramAnonymousa.T(paramAnonymousv);
          AppMethodBeat.o(123317);
          return;
          paramAnonymousa.bND();
          e.a(e.this).nT(paramAnonymousa.nLz.field_msgId);
          e.a(e.this).nQ(paramAnonymousa.nLz.field_msgId);
          if (e.a(e.this).bNM()) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123316);
                e.this.nMx.aql.notifyChanged();
                AppMethodBeat.o(123316);
              }
            });
          }
          e.this.nMs.bNP();
        }
      }
    };
    d locald = this.nMx;
    AppMethodBeat.o(123323);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e
 * JD-Core Version:    0.7.0.1
 */