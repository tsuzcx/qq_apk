package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public final class f
  extends b
{
  int fq;
  public c oTb;
  private com.tencent.mm.sdk.b.c oTc;
  private GridLayoutManager oTd;
  int oTe;
  
  public f(com.tencent.mm.plugin.choosemsgfile.ui.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(123339);
    this.fq = 0;
    this.oTe = 0;
    this.oTc = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(123339);
  }
  
  public final RecyclerView.a bZA()
  {
    AppMethodBeat.i(123344);
    this.oTb = new c(this.oSN, this.mDataList);
    this.oTb.oSP = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.b.b.a paramAnonymousa, final RecyclerView.w paramAnonymousw)
      {
        AppMethodBeat.i(123334);
        if (paramAnonymousa == null)
        {
          ad.e("MicroMsg.ChooseMsgFileUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(123334);
          return;
        }
        ad.i("MicroMsg.ChooseMsgFileUIController", "[onCheck] isChecked:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.bZp();
          f.a(f.this).tD(paramAnonymousa.oRU.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.b.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.b.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123328);
              ad.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              f.a(f.this).tE(paramAnonymousa.oRU.field_msgId);
              f.a(f.this).a(paramAnonymousa.oRU.field_msgId, paramAnonymous2MsgFile);
              if (f.a(f.this).bZC()) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123327);
                    f.this.oTb.asY.notifyChanged();
                    AppMethodBeat.o(123327);
                  }
                });
              }
              f.this.oSN.bZF();
              paramAnonymousa.bZq();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).oSB.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.T(paramAnonymousw);
              }
              AppMethodBeat.o(123328);
            }
            
            public final void bZe()
            {
              AppMethodBeat.i(123329);
              ad.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              f.a(f.this).tE(paramAnonymousa.oRU.field_msgId);
              paramAnonymousa.bZs();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).oSB.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123329);
            }
            
            public final void bZf()
            {
              AppMethodBeat.i(123330);
              ad.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              f.a(f.this).tE(paramAnonymousa.oRU.field_msgId);
              paramAnonymousa.bZt();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).oSB.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123330);
            }
            
            public final void bZg()
            {
              AppMethodBeat.i(123331);
              ad.e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              f.a(f.this).tE(paramAnonymousa.oRU.field_msgId);
              paramAnonymousa.bZr();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).oSB.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123331);
            }
            
            public final void eW(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123332);
              ad.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.eY(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).oSB.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123332);
            }
          }, f.this.bZz());
        }
        for (;;)
        {
          paramAnonymousa.T(paramAnonymousw);
          AppMethodBeat.o(123334);
          return;
          paramAnonymousa.bZt();
          f.a(f.this).tE(paramAnonymousa.oRU.field_msgId);
          f.a(f.this).tB(paramAnonymousa.oRU.field_msgId);
          if (f.a(f.this).bZC()) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123333);
                f.this.oTb.asY.notifyChanged();
                AppMethodBeat.o(123333);
              }
            });
          }
          f.this.oSN.bZF();
        }
      }
    };
    c localc = this.oTb;
    AppMethodBeat.o(123344);
    return localc;
  }
  
  public final <T extends RecyclerView.i> T bZB()
  {
    AppMethodBeat.i(123345);
    if (this.oTd == null)
    {
      this.oTd = new GridLayoutManager(4);
      this.oTd.apF = new GridLayoutManager.b()
      {
        public final int bW(int paramAnonymousInt)
        {
          AppMethodBeat.i(123335);
          if (((com.tencent.mm.plugin.choosemsgfile.b.b.a)f.this.mDataList.get(paramAnonymousInt)).getType() == 0)
          {
            AppMethodBeat.o(123335);
            return 4;
          }
          AppMethodBeat.o(123335);
          return 1;
        }
      };
    }
    GridLayoutManager localGridLayoutManager = this.oTd;
    AppMethodBeat.o(123345);
    return localGridLayoutManager;
  }
  
  public final void c(final boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123346);
    if (paramBoolean)
    {
      this.mDataList.clear();
      this.fq = 0;
    }
    this.oTb.oSR = true;
    this.oSN.jD(paramBoolean);
    g.ajD();
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123338);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((l)g.ab(l.class)).dlK().eg(f.this.fGM, f.this.fq);
        if (localCursor == null)
        {
          ad.e("MicroMsg.ChooseMsgFileUIController", "[loadData] NULL == cursor ");
          AppMethodBeat.o(123338);
          return;
        }
        long l1 = 0L;
        label723:
        for (;;)
        {
          Object localObject2;
          long l2;
          try
          {
            Object localObject4;
            if (localCursor.moveToNext())
            {
              f.b(f.this);
              localObject2 = new bu();
              ((bu)localObject2).convertFrom(localCursor);
              localObject3 = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.oTb, (bu)localObject2, f.this.fGM, paramString1, paramString2);
              if (localObject3 == null) {
                break label723;
              }
              localObject4 = new Date(((ei)localObject2).field_createTime);
              l2 = com.tencent.mm.ui.gridviewheaders.a.fJG().b((Date)localObject4);
              if (l1 != l2)
              {
                localLinkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.oTb, ((ei)localObject2).field_createTime));
                f.c(f.this);
              }
              localLinkedList.add(localObject3);
              l1 = l2;
              continue;
            }
            localCursor.close();
            localObject2 = new LinkedList();
            if (localLinkedList.size() - f.this.oTe != 200) {
              break label614;
            }
            l1 = ((com.tencent.mm.plugin.choosemsgfile.b.b.a)localLinkedList.get(0)).getTimeStamp();
            com.tencent.mm.ui.gridviewheaders.a.fJG();
            l2 = com.tencent.mm.ui.gridviewheaders.a.Eq(l1);
            ad.i("MicroMsg.ChooseMsgFileUIController", "[loadData] list size:%s start:%s end:%s", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(l2), Long.valueOf(l1) });
            localCursor = ((l)g.ab(l.class)).dlK().B(f.this.fGM, l2, l1);
            Object localObject3 = new Date(l1);
            l1 = com.tencent.mm.ui.gridviewheaders.a.fJG().b((Date)localObject3);
            if (localCursor == null) {
              break label602;
            }
            try
            {
              if (!localCursor.moveToNext()) {
                break label602;
              }
              f.b(f.this);
              localObject4 = new bu();
              ((bu)localObject4).convertFrom(localCursor);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.oTb, (bu)localObject4, f.this.fGM, paramString1, paramString2);
              if (locala == null) {
                continue;
              }
              Date localDate = new Date(((ei)localObject4).field_createTime);
              l2 = com.tencent.mm.ui.gridviewheaders.a.fJG().b(localDate);
              if ((l1 != l2) && (com.tencent.mm.ui.gridviewheaders.a.fJG().b((Date)localObject3) != l2))
              {
                ((LinkedList)localObject2).add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.oTb, ((ei)localObject4).field_createTime));
                f.c(f.this);
                ((LinkedList)localObject2).add(locala);
                l1 = l2;
                continue;
              }
            }
            finally
            {
              if (localCursor == null) {}
            }
            l2 = l1;
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(123338);
          }
          if (localCollection.size() > 0)
          {
            l2 = l1;
            if (((LinkedList)localObject2).size() == 0)
            {
              ((LinkedList)localObject2).add(0, localCollection.remove(0));
              l2 = l1;
              continue;
              label602:
              if (localCursor != null) {
                localCursor.close();
              }
              label614:
              int i = localCollection.size();
              int j = ((LinkedList)localObject2).size();
              f.this.mDataList.addAll(0, (Collection)localObject2);
              f.this.mDataList.addAll(((LinkedList)localObject2).size(), localCollection);
              localCollection.clear();
              ((LinkedList)localObject2).clear();
              f.this.oTe = 0;
              ad.i("MicroMsg.ChooseMsgFileUIController", "[loadData] %s", new Object[] { Integer.valueOf(f.this.mDataList.size()) });
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123337);
                  f.this.oTb.oSR = false;
                  f.this.oSN.B(f.5.this.oSY, this.oTi);
                  AppMethodBeat.o(123337);
                }
              });
              AppMethodBeat.o(123338);
              return;
            }
          }
        }
      }
    });
    AppMethodBeat.o(123346);
  }
  
  public final void fh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123340);
    ad.i("MicroMsg.ChooseMsgFileUIController", "onCreate");
    this.oTc.alive();
    c(true, paramString1, paramString2);
    AppMethodBeat.o(123340);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123343);
    ad.i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
    this.oTc.dead();
    AppMethodBeat.o(123343);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(123342);
    ad.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(123342);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(123341);
    ad.i("MicroMsg.ChooseMsgFileUIController", "onResume");
    this.oTb.asY.notifyChanged();
    AppMethodBeat.o(123341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.f
 * JD-Core Version:    0.7.0.1
 */