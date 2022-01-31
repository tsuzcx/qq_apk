package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public abstract class a<T>
  extends BaseAdapter
{
  private static int nuI = 500;
  protected Context mContext;
  protected LinkedList<T> noR;
  private a.a nuF;
  protected boolean nuG = false;
  private f<String, Bitmap> nuH;
  private ap nuJ = new ap(new a.2(this), false);
  private final k.a nuK = new a.3(this);
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.noR = new LinkedList();
    this.nuH = new b(20, getClass());
    com.tencent.mm.plugin.s.a.cac().add(this.nuK);
  }
  
  protected final Bitmap Qp(String paramString)
  {
    Object localObject;
    if (bo.isNullOrNil(paramString)) {
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
          if (!this.nuH.Z(paramString)) {
            break;
          }
          localBitmap = (Bitmap)this.nuH.get(paramString);
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
    this.nuH.f(paramString, localBitmap);
    return localBitmap;
  }
  
  public void ab(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.nuF != null) {
        this.noR.size();
      }
      return;
    }
    this.noR.addAll(paramLinkedList);
    if (this.nuF != null) {
      this.noR.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void ac(LinkedList<T> paramLinkedList)
  {
    if (paramLinkedList == null)
    {
      if (this.nuF != null) {
        this.noR.size();
      }
      return;
    }
    this.noR = paramLinkedList;
    if (this.nuF != null) {
      this.noR.size();
    }
    super.notifyDataSetChanged();
  }
  
  public void clear()
  {
    if (this.noR != null) {
      this.noR.clear();
    }
    if (this.nuH != null) {
      this.nuH.a(new a.1(this));
    }
    this.nuH = null;
    com.tencent.mm.plugin.s.a.cac().remove(this.nuK);
  }
  
  public int getCount()
  {
    return this.noR.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.noR.get(paramInt);
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