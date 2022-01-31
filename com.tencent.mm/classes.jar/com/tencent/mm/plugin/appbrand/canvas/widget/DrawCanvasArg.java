package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawCanvasArg
  implements Parcelable
{
  public static final Parcelable.Creator<DrawCanvasArg> CREATOR = new DrawCanvasArg.2();
  public boolean fMF;
  public String fMG;
  public long fMH;
  public boolean fMI;
  public JSONArray fMJ;
  public volatile Runnable fMK;
  private volatile boolean fML = false;
  public volatile boolean fMM = false;
  protected volatile int fMN;
  protected volatile int fMO;
  public List<DrawActionWrapper> fMg = new ArrayList();
  
  public DrawCanvasArg() {}
  
  public DrawCanvasArg(Parcel paramParcel)
  {
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.fMF = bool1;
      this.fMG = paramParcel.readString();
      this.fMg = paramParcel.readArrayList(DrawCanvasArg.class.getClassLoader());
      this.fMH = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.fMI = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void g(JSONArray paramJSONArray)
  {
    int i = 0;
    DrawActionWrapper localDrawActionWrapper;
    if ((i < paramJSONArray.length()) && (!this.fML))
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      BaseDrawActionArg localBaseDrawActionArg = c.adI().rK(localJSONObject.optString("method"));
      localDrawActionWrapper = (DrawActionWrapper)d.adJ().fMl.de();
      localObject = localDrawActionWrapper;
      if (localDrawActionWrapper == null) {
        localObject = new DrawActionWrapper();
      }
      if (localBaseDrawActionArg != null)
      {
        ((DrawActionWrapper)localObject).type = 2;
        localBaseDrawActionArg.j(localJSONObject);
        ((DrawActionWrapper)localObject).fLA = localBaseDrawActionArg;
      }
      for (;;)
      {
        this.fMg.add(localObject);
        i += 1;
        break;
        ((DrawActionWrapper)localObject).type = 1;
        ((DrawActionWrapper)localObject).fLB = localJSONObject;
      }
    }
    paramJSONArray = new LinkedList();
    Object localObject = new ArrayList();
    this.fMO += this.fMg.size();
    int j = this.fMg.size() - 1;
    i = 0;
    if (j >= 0)
    {
      localDrawActionWrapper = (DrawActionWrapper)this.fMg.get(j);
      boolean bool;
      switch (localDrawActionWrapper.type)
      {
      default: 
        bool = false;
        label231:
        if (bool)
        {
          y.i("DrawCanvasArg", "found redudant method %s", new Object[] { localDrawActionWrapper.getMethod() });
          ((List)localObject).add(localDrawActionWrapper);
          i += 1;
        }
        break;
      }
      for (;;)
      {
        j -= 1;
        break;
        bool = false;
        break label231;
        bool = localDrawActionWrapper.fLA.adF();
        break label231;
        if ("save".equals(localDrawActionWrapper.getMethod()))
        {
          if ((paramJSONArray.size() > 0) && (((DrawActionWrapper)paramJSONArray.getLast()).getMethod().equals("restore")))
          {
            ((List)localObject).add(localDrawActionWrapper);
            ((List)localObject).add(paramJSONArray.removeLast());
          }
          else
          {
            do
            {
              if (paramJSONArray.size() <= 0) {
                break;
              }
            } while (!((DrawActionWrapper)paramJSONArray.removeLast()).getMethod().equals("restore"));
          }
        }
        else {
          paramJSONArray.addLast(localDrawActionWrapper);
        }
      }
    }
    this.fMN += ((List)localObject).size();
    paramJSONArray = ((List)localObject).iterator();
    while (paramJSONArray.hasNext())
    {
      localObject = (DrawActionWrapper)paramJSONArray.next();
      this.fMg.remove(localObject);
      ((DrawActionWrapper)localObject).reset();
    }
    y.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", new Object[] { Integer.valueOf(this.fMN), Integer.valueOf(i), Integer.valueOf(this.fMO) });
  }
  
  private void release()
  {
    try
    {
      y.i("DrawCanvasArg", "release %s", new Object[] { toString() });
      this.fMO = 0;
      this.fMN = 0;
      this.fMK = null;
      this.fMF = false;
      this.fMJ = null;
      this.fMG = null;
      this.fMH = 0L;
      this.fMI = false;
      this.fML = false;
      this.fMM = false;
      Iterator localIterator = this.fMg.iterator();
      while (localIterator.hasNext())
      {
        DrawActionWrapper localDrawActionWrapper = (DrawActionWrapper)localIterator.next();
        if (localDrawActionWrapper != null) {
          localDrawActionWrapper.reset();
        }
        localIterator.remove();
      }
      locald = d.adJ();
    }
    finally {}
    d locald;
    if (this != null) {
      locald.fMk.D(this);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void k(JSONObject paramJSONObject)
  {
    g(paramJSONObject.optJSONArray("actions"));
  }
  
  public final void reset()
  {
    if ((this.fMK != null) && (!e.remove(this.fMK)))
    {
      y.i("DrawCanvasArg", "wait for async over");
      this.fML = true;
      return;
    }
    release();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (this.fMF)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.fMG);
      paramParcel.writeList(this.fMg);
      paramParcel.writeLong(this.fMH);
      if (!this.fMI) {
        break label60;
      }
    }
    label60:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg
 * JD-Core Version:    0.7.0.1
 */