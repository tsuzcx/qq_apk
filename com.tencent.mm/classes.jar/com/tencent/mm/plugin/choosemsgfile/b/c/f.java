package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.database.Cursor;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public final class f
  extends b
{
  int LZ;
  public c nMG;
  private com.tencent.mm.sdk.b.c nMH;
  private GridLayoutManager nMI;
  int nMJ;
  
  public f(com.tencent.mm.plugin.choosemsgfile.ui.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(123339);
    this.LZ = 0;
    this.nMJ = 0;
    this.nMH = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(123339);
  }
  
  public final void b(final boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123346);
    if (paramBoolean)
    {
      this.hIH.clear();
      this.LZ = 0;
    }
    this.nMG.nMw = true;
    this.nMs.iP(paramBoolean);
    g.afC();
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123338);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((k)g.ab(k.class)).cOI().dI(f.this.flk, f.this.LZ);
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
              localObject2 = new bl();
              ((bl)localObject2).convertFrom(localCursor);
              localObject3 = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.nMG, (bl)localObject2, f.this.flk, paramString1, paramString2);
              if (localObject3 == null) {
                break label723;
              }
              localObject4 = new Date(((du)localObject2).field_createTime);
              l2 = com.tencent.mm.ui.gridviewheaders.a.fcX().b((Date)localObject4);
              if (l1 != l2)
              {
                localLinkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.nMG, ((du)localObject2).field_createTime));
                f.c(f.this);
              }
              localLinkedList.add(localObject3);
              l1 = l2;
              continue;
            }
            localCursor.close();
            localObject2 = new LinkedList();
            if (localLinkedList.size() - f.this.nMJ != 200) {
              break label614;
            }
            l1 = ((com.tencent.mm.plugin.choosemsgfile.b.b.a)localLinkedList.get(0)).getTimeStamp();
            com.tencent.mm.ui.gridviewheaders.a.fcX();
            l2 = com.tencent.mm.ui.gridviewheaders.a.wV(l1);
            ad.i("MicroMsg.ChooseMsgFileUIController", "[loadData] list size:%s start:%s end:%s", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(l2), Long.valueOf(l1) });
            localCursor = ((k)g.ab(k.class)).cOI().C(f.this.flk, l2, l1);
            Object localObject3 = new Date(l1);
            l1 = com.tencent.mm.ui.gridviewheaders.a.fcX().b((Date)localObject3);
            if (localCursor == null) {
              break label602;
            }
            try
            {
              if (!localCursor.moveToNext()) {
                break label602;
              }
              f.b(f.this);
              localObject4 = new bl();
              ((bl)localObject4).convertFrom(localCursor);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.nMG, (bl)localObject4, f.this.flk, paramString1, paramString2);
              if (locala == null) {
                continue;
              }
              Date localDate = new Date(((du)localObject4).field_createTime);
              l2 = com.tencent.mm.ui.gridviewheaders.a.fcX().b(localDate);
              if ((l1 != l2) && (com.tencent.mm.ui.gridviewheaders.a.fcX().b((Date)localObject3) != l2))
              {
                ((LinkedList)localObject2).add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.nMG, ((du)localObject4).field_createTime));
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
              f.this.hIH.addAll(0, (Collection)localObject2);
              f.this.hIH.addAll(((LinkedList)localObject2).size(), localCollection);
              localCollection.clear();
              ((LinkedList)localObject2).clear();
              f.this.nMJ = 0;
              ad.i("MicroMsg.ChooseMsgFileUIController", "[loadData] %s", new Object[] { Integer.valueOf(f.this.hIH.size()) });
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123337);
                  f.this.nMG.nMw = false;
                  f.this.nMs.A(f.5.this.nMD, this.nMN);
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
  
  public final RecyclerView.a bNK()
  {
    AppMethodBeat.i(123344);
    this.nMG = new c(this.nMs, this.hIH);
    this.nMG.nMu = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.b.b.a paramAnonymousa, final RecyclerView.v paramAnonymousv)
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
          paramAnonymousa.bNz();
          f.a(f.this).nS(paramAnonymousa.nLz.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.b.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.b.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123328);
              ad.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              f.a(f.this).nT(paramAnonymousa.nLz.field_msgId);
              f.a(f.this).a(paramAnonymousa.nLz.field_msgId, paramAnonymous2MsgFile);
              if (f.a(f.this).bNM()) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123327);
                    f.this.nMG.aql.notifyChanged();
                    AppMethodBeat.o(123327);
                  }
                });
              }
              f.this.nMs.bNP();
              paramAnonymousa.bNA();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).nMg.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.T(paramAnonymousv);
              }
              AppMethodBeat.o(123328);
            }
            
            public final void bNo()
            {
              AppMethodBeat.i(123329);
              ad.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              f.a(f.this).nT(paramAnonymousa.nLz.field_msgId);
              paramAnonymousa.bNC();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).nMg.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousv);
              }
              AppMethodBeat.o(123329);
            }
            
            public final void bNp()
            {
              AppMethodBeat.i(123330);
              ad.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              f.a(f.this).nT(paramAnonymousa.nLz.field_msgId);
              paramAnonymousa.bND();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).nMg.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousv);
              }
              AppMethodBeat.o(123330);
            }
            
            public final void bNq()
            {
              AppMethodBeat.i(123331);
              ad.e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              f.a(f.this).nT(paramAnonymousa.nLz.field_msgId);
              paramAnonymousa.bNB();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).nMg.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousv);
              }
              AppMethodBeat.o(123331);
            }
            
            public final void eP(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123332);
              ad.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.eR(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).nMg.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousv);
              }
              AppMethodBeat.o(123332);
            }
          }, f.this.bNJ());
        }
        for (;;)
        {
          paramAnonymousa.T(paramAnonymousv);
          AppMethodBeat.o(123334);
          return;
          paramAnonymousa.bND();
          f.a(f.this).nT(paramAnonymousa.nLz.field_msgId);
          f.a(f.this).nQ(paramAnonymousa.nLz.field_msgId);
          if (f.a(f.this).bNM()) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123333);
                f.this.nMG.aql.notifyChanged();
                AppMethodBeat.o(123333);
              }
            });
          }
          f.this.nMs.bNP();
        }
      }
    };
    c localc = this.nMG;
    AppMethodBeat.o(123344);
    return localc;
  }
  
  public final <T extends RecyclerView.i> T bNL()
  {
    AppMethodBeat.i(123345);
    if (this.nMI == null)
    {
      this.nMI = new GridLayoutManager(4);
      this.nMI.amS = new GridLayoutManager.b()
      {
        public final int bW(int paramAnonymousInt)
        {
          AppMethodBeat.i(123335);
          if (((com.tencent.mm.plugin.choosemsgfile.b.b.a)f.this.hIH.get(paramAnonymousInt)).getType() == 0)
          {
            AppMethodBeat.o(123335);
            return 4;
          }
          AppMethodBeat.o(123335);
          return 1;
        }
      };
    }
    GridLayoutManager localGridLayoutManager = this.nMI;
    AppMethodBeat.o(123345);
    return localGridLayoutManager;
  }
  
  public final void eK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123340);
    ad.i("MicroMsg.ChooseMsgFileUIController", "onCreate");
    this.nMH.alive();
    b(true, paramString1, paramString2);
    AppMethodBeat.o(123340);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123343);
    ad.i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
    this.nMH.dead();
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
    this.nMG.aql.notifyChanged();
    AppMethodBeat.o(123341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.f
 * JD-Core Version:    0.7.0.1
 */