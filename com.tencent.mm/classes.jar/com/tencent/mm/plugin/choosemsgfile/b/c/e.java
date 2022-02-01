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
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.k;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends b
{
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> ndS;
  public LinearLayoutManager ntR;
  d oZu;
  
  public e(com.tencent.mm.plugin.choosemsgfile.ui.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(123322);
    this.ndS = new ArrayList();
    AppMethodBeat.o(123322);
  }
  
  public final void c(final boolean paramBoolean, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123324);
    ae.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oZp.jC(paramBoolean);
    if (paramBoolean) {
      this.ndS.clear();
    }
    g.ajS();
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123319);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((l)g.ab(l.class)).doJ().el(e.this.fIQ, -1);
        if (localCursor == null)
        {
          ae.e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
          AppMethodBeat.o(123319);
          return;
        }
        List localList = com.tencent.mm.plugin.choosemsgfile.b.d.c.aat(paramString2);
        long l1 = 0L;
        label390:
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              bv localbv = new bv();
              localbv.convertFrom(localCursor);
              Object localObject2 = localbv.field_content;
              if (localObject2 == null) {
                break label390;
              }
              localObject2 = k.b.zb((String)localObject2);
              if ((localObject2 == null) || (((k.b)localObject2).type != 6)) {
                break label390;
              }
              localObject2 = new k(e.this.oZu, localbv, e.this.fIQ);
              if (localList.size() == 0)
              {
                i = 1;
                if (i == 0) {
                  continue;
                }
                localObject3 = new Date(localbv.field_createTime);
                long l2 = com.tencent.mm.ui.gridviewheaders.a.fNX().b((Date)localObject3);
                if (l1 != l2) {
                  localLinkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.i(e.this.oZu, localbv.field_createTime));
                }
                localLinkedList.add(localObject2);
                l1 = l2;
                break label390;
              }
              Object localObject3 = localList.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                String str = (String)((Iterator)localObject3).next();
                boolean bool = ((k)localObject2).getFileName().endsWith(str);
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
              e.this.ndS.addAll(localLinkedList);
              localLinkedList.clear();
              ae.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", new Object[] { Integer.valueOf(e.this.ndS.size()) });
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123318);
                  if (e.this.oZp != null) {
                    e.this.oZp.C(e.2.this.oZA, e.this.ndS.size());
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
  
  public final RecyclerView.a caP()
  {
    AppMethodBeat.i(123323);
    this.oZu = new d(this.oZp, this.ndS);
    a.oZs = new g.b() {};
    this.oZu.oZr = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.b.b.a paramAnonymousa, final RecyclerView.w paramAnonymousw)
      {
        AppMethodBeat.i(123317);
        if (paramAnonymousa == null)
        {
          ae.e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(123317);
          return;
        }
        ae.i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.caE();
          e.a(e.this).tU(paramAnonymousa.oYw.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.b.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.b.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123311);
              ae.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              e.a(e.this).tV(paramAnonymousa.oYw.field_msgId);
              e.a(e.this).a(paramAnonymousa.oYw.field_msgId, paramAnonymous2MsgFile);
              if (e.a(e.this).caR()) {
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123310);
                    e.this.oZu.asY.notifyChanged();
                    AppMethodBeat.o(123310);
                  }
                });
              }
              e.this.oZp.caU();
              paramAnonymousa.caF();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousw).oZa.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.T(paramAnonymousw);
              }
              AppMethodBeat.o(123311);
            }
            
            public final void cat()
            {
              AppMethodBeat.i(123312);
              ae.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              e.a(e.this).tV(paramAnonymousa.oYw.field_msgId);
              paramAnonymousa.caH();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousw).oZa.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123312);
            }
            
            public final void cau()
            {
              AppMethodBeat.i(123313);
              ae.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              e.a(e.this).tV(paramAnonymousa.oYw.field_msgId);
              paramAnonymousa.caI();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousw).oZa.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123313);
            }
            
            public final void cav()
            {
              AppMethodBeat.i(123314);
              ae.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              e.a(e.this).tV(paramAnonymousa.oYw.field_msgId);
              paramAnonymousa.caG();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousw).oZa.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123314);
            }
            
            public final void eX(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123315);
              ae.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.eZ(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousw).oZa.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123315);
            }
          }, e.this.caO());
        }
        for (;;)
        {
          paramAnonymousa.T(paramAnonymousw);
          AppMethodBeat.o(123317);
          return;
          paramAnonymousa.caI();
          e.a(e.this).tV(paramAnonymousa.oYw.field_msgId);
          e.a(e.this).tS(paramAnonymousa.oYw.field_msgId);
          if (e.a(e.this).caR()) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123316);
                e.this.oZu.asY.notifyChanged();
                AppMethodBeat.o(123316);
              }
            });
          }
          e.this.oZp.caU();
        }
      }
    };
    d locald = this.oZu;
    AppMethodBeat.o(123323);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e
 * JD-Core Version:    0.7.0.1
 */