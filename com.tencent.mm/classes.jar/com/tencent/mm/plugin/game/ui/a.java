package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public abstract class a<T>
  extends BaseAdapter
{
  private static int kWG = 500;
  protected LinkedList<T> kQN;
  private a.a kWD;
  protected boolean kWE = false;
  private f<String, Bitmap> kWF;
  private am kWH = new am(new a.2(this), false);
  private final j.a kWI = new a.3(this);
  protected Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.kQN = new LinkedList();
    this.kWF = new f(20);
    com.tencent.mm.plugin.z.a.brn().c(this.kWI);
  }
  
  protected final Bitmap EX(String paramString)
  {
    Object localObject;
    if (bk.bl(paramString)) {
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
          if (!this.kWF.aC(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.kWF.get(paramString);
          if (localBitmap == null) {
            break;
          }
          localObject = localBitmap;
        } while (!localBitmap.isRecycled());
        localBitmap = g.b(paramString, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
        localObject = localBitmap;
      } while (localBitmap == null);
      localObject = localBitmap;
    } while (localBitmap.isRecycled());
    this.kWF.f(paramString, localBitmap);
    return localBitmap;
  }
  
  public void U(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.kWD != null) {
        this.kQN.size();
      }
      return;
    }
    this.kQN.addAll(paramLinkedList);
    if (this.kWD != null) {
      this.kQN.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void V(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.kWD != null) {
        this.kQN.size();
      }
      return;
    }
    this.kQN = paramLinkedList;
    if (this.kWD != null) {
      this.kQN.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.kQN != null) {
      this.kQN.clear();
    }
    if (this.kWF != null) {
      this.kWF.a(new a.1(this));
    }
    this.kWF = null;
    com.tencent.mm.plugin.z.a.brn().d(this.kWI);
  }
  
  public int getCount()
  {
    return this.kQN.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.kQN.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.a
 * JD-Core Version:    0.7.0.1
 */