package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public final class f
  extends b
{
  int fs;
  public c qoB;
  private IListener qoC;
  private GridLayoutManager qoD;
  int qoE;
  
  public f(com.tencent.mm.plugin.choosemsgfile.ui.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(123339);
    this.fs = 0;
    this.qoE = 0;
    this.qoC = new IListener() {};
    AppMethodBeat.o(123339);
  }
  
  public final void c(final boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123346);
    if (paramBoolean)
    {
      this.mDataList.clear();
      this.fs = 0;
    }
    this.qoB.qor = true;
    this.qon.kF(paramBoolean);
    g.aAi();
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123338);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((l)g.af(l.class)).eiy().eB(f.this.goe, f.this.fs);
        if (localCursor == null)
        {
          Log.e("MicroMsg.ChooseMsgFileUIController", "[loadData] NULL == cursor ");
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
              localObject2 = new ca();
              ((ca)localObject2).convertFrom(localCursor);
              localObject3 = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.qoB, (ca)localObject2, f.this.goe, paramString1, paramString2);
              if (localObject3 == null) {
                break label723;
              }
              localObject4 = new Date(((eo)localObject2).field_createTime);
              l2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b((Date)localObject4);
              if (l1 != l2)
              {
                localLinkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.qoB, ((eo)localObject2).field_createTime));
                f.c(f.this);
              }
              localLinkedList.add(localObject3);
              l1 = l2;
              continue;
            }
            localCursor.close();
            localObject2 = new LinkedList();
            if (localLinkedList.size() - f.this.qoE != 200) {
              break label614;
            }
            l1 = ((com.tencent.mm.plugin.choosemsgfile.b.b.a)localLinkedList.get(0)).getTimeStamp();
            com.tencent.mm.ui.gridviewheaders.a.gWr();
            l2 = com.tencent.mm.ui.gridviewheaders.a.NX(l1);
            Log.i("MicroMsg.ChooseMsgFileUIController", "[loadData] list size:%s start:%s end:%s", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(l2), Long.valueOf(l1) });
            localCursor = ((l)g.af(l.class)).eiy().C(f.this.goe, l2, l1);
            Object localObject3 = new Date(l1);
            l1 = com.tencent.mm.ui.gridviewheaders.a.gWr().b((Date)localObject3);
            if (localCursor == null) {
              break label602;
            }
            try
            {
              if (!localCursor.moveToNext()) {
                break label602;
              }
              f.b(f.this);
              localObject4 = new ca();
              ((ca)localObject4).convertFrom(localCursor);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.qoB, (ca)localObject4, f.this.goe, paramString1, paramString2);
              if (locala == null) {
                continue;
              }
              Date localDate = new Date(((eo)localObject4).field_createTime);
              l2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(localDate);
              if ((l1 != l2) && (com.tencent.mm.ui.gridviewheaders.a.gWr().b((Date)localObject3) != l2))
              {
                ((LinkedList)localObject2).add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.qoB, ((eo)localObject4).field_createTime));
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
              f.this.qoE = 0;
              Log.i("MicroMsg.ChooseMsgFileUIController", "[loadData] %s", new Object[] { Integer.valueOf(f.this.mDataList.size()) });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123337);
                  f.this.qoB.qor = false;
                  f.this.qon.D(f.5.this.qoy, this.qoI);
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
  
  public final RecyclerView.a cyF()
  {
    AppMethodBeat.i(123344);
    this.qoB = new c(this.qon, this.mDataList);
    this.qoB.qop = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.b.b.a paramAnonymousa, final RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(123334);
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.ChooseMsgFileUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(123334);
          return;
        }
        Log.i("MicroMsg.ChooseMsgFileUIController", "[onCheck] isChecked:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.cyu();
          f.a(f.this).BZ(paramAnonymousa.qnv.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.b.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.b.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123328);
              Log.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              f.a(f.this).Ca(paramAnonymousa.qnv.field_msgId);
              f.a(f.this).a(paramAnonymousa.qnv.field_msgId, paramAnonymous2MsgFile);
              if (f.a(f.this).cyG()) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123327);
                    f.this.qoB.atj.notifyChanged();
                    AppMethodBeat.o(123327);
                  }
                });
              }
              f.this.qon.cyJ();
              paramAnonymousa.cyv();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).puw.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.V(paramAnonymousv);
              }
              AppMethodBeat.o(123328);
            }
            
            public final void cyk()
            {
              AppMethodBeat.i(123329);
              Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              f.a(f.this).Ca(paramAnonymousa.qnv.field_msgId);
              paramAnonymousa.cyx();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).puw.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123329);
            }
            
            public final void cyl()
            {
              AppMethodBeat.i(123330);
              Log.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              f.a(f.this).Ca(paramAnonymousa.qnv.field_msgId);
              paramAnonymousa.cyy();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).puw.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123330);
            }
            
            public final void cym()
            {
              AppMethodBeat.i(123331);
              Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              f.a(f.this).Ca(paramAnonymousa.qnv.field_msgId);
              paramAnonymousa.cyw();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).puw.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123331);
            }
            
            public final void fk(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123332);
              Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.fm(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousv).puw.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123332);
            }
          }, f.this.cyE());
        }
        for (;;)
        {
          paramAnonymousa.V(paramAnonymousv);
          AppMethodBeat.o(123334);
          return;
          paramAnonymousa.cyy();
          f.a(f.this).Ca(paramAnonymousa.qnv.field_msgId);
          f.a(f.this).BX(paramAnonymousa.qnv.field_msgId);
          if (f.a(f.this).cyG()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123333);
                f.this.qoB.atj.notifyChanged();
                AppMethodBeat.o(123333);
              }
            });
          }
          f.this.qon.cyJ();
        }
      }
    };
    c localc = this.qoB;
    AppMethodBeat.o(123344);
    return localc;
  }
  
  public final <T extends RecyclerView.LayoutManager> T eS(Context paramContext)
  {
    AppMethodBeat.i(237144);
    if (this.qoD == null)
    {
      this.qoD = new GridLayoutManager(4);
      this.qoD.apR = new GridLayoutManager.b()
      {
        public final int bX(int paramAnonymousInt)
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
    paramContext = this.qoD;
    AppMethodBeat.o(237144);
    return paramContext;
  }
  
  public final void fC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123340);
    Log.i("MicroMsg.ChooseMsgFileUIController", "onCreate");
    this.qoC.alive();
    c(true, paramString1, paramString2);
    AppMethodBeat.o(123340);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123343);
    Log.i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
    this.qoC.dead();
    AppMethodBeat.o(123343);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(123342);
    Log.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(123342);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(123341);
    Log.i("MicroMsg.ChooseMsgFileUIController", "onResume");
    this.qoB.atj.notifyChanged();
    AppMethodBeat.o(123341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.f
 * JD-Core Version:    0.7.0.1
 */