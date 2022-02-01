package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.LinkedList;

public abstract class a<T>
  extends BaseAdapter
{
  private static int IMD = 500;
  protected LinkedList<T> IFF;
  private a IMA;
  protected boolean IMB = false;
  private f<String, Bitmap> IMC;
  private MTimerHandler IME = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(41856);
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(41856);
      return false;
    }
  }, false);
  private final MStorage.IOnStorageChange IMF = new MStorage.IOnStorageChange()
  {
    public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
    {
      AppMethodBeat.i(41857);
      a.a(a.this).stopTimer();
      a.a(a.this).startTimer(a.IMD);
      AppMethodBeat.o(41857);
    }
  };
  protected Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.IFF = new LinkedList();
    this.IMC = new b(20, getClass());
    com.tencent.mm.plugin.openapi.a.gxn().add(this.IMF);
  }
  
  protected final Bitmap aHb(String paramString)
  {
    Object localObject;
    if (Util.isNullOrNil(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      do
      {
        do
        {
          return localObject;
          if (!this.IMC.check(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.IMC.get(paramString);
          if (localBitmap == null) {
            break;
          }
          localObject = localBitmap;
        } while (!localBitmap.isRecycled());
        localBitmap = h.c(paramString, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
        localObject = localBitmap;
      } while (localBitmap == null);
      localObject = localBitmap;
    } while (localBitmap.isRecycled());
    this.IMC.B(paramString, localBitmap);
    return localBitmap;
  }
  
  public void bu(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.IMA != null) {
        this.IFF.size();
      }
      return;
    }
    this.IFF.addAll(paramLinkedList);
    if (this.IMA != null) {
      this.IFF.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void bv(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.IMA != null) {
        this.IFF.size();
      }
      return;
    }
    this.IFF = paramLinkedList;
    if (this.IMA != null) {
      this.IFF.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.IFF != null) {
      this.IFF.clear();
    }
    if (this.IMC != null) {
      this.IMC.a(new f.a() {});
    }
    this.IMC = null;
    com.tencent.mm.plugin.openapi.a.gxn().remove(this.IMF);
  }
  
  public int getCount()
  {
    return this.IFF.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.IFF.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.a
 * JD-Core Version:    0.7.0.1
 */