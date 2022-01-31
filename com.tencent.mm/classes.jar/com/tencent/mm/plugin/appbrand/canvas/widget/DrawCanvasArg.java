package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawCanvasArg
  implements Parcelable
{
  public static final Parcelable.Creator<DrawCanvasArg> CREATOR;
  public boolean hfP;
  public String hfQ;
  public long hfR;
  public boolean hfS;
  public JSONArray hfT;
  public volatile Runnable hfU;
  private volatile boolean hfV;
  public volatile boolean hfW;
  protected volatile int hfX;
  protected volatile int hfY;
  public List<DrawActionWrapper> hfq;
  
  static
  {
    AppMethodBeat.i(103710);
    CREATOR = new DrawCanvasArg.2();
    AppMethodBeat.o(103710);
  }
  
  public DrawCanvasArg()
  {
    AppMethodBeat.i(103702);
    this.hfq = new ArrayList();
    this.hfV = false;
    this.hfW = false;
    AppMethodBeat.o(103702);
  }
  
  public DrawCanvasArg(Parcel paramParcel)
  {
    AppMethodBeat.i(103703);
    this.hfq = new ArrayList();
    this.hfV = false;
    this.hfW = false;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.hfP = bool1;
      this.hfQ = paramParcel.readString();
      this.hfq = paramParcel.readArrayList(DrawCanvasArg.class.getClassLoader());
      this.hfR = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hfS = bool1;
      AppMethodBeat.o(103703);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void release()
  {
    try
    {
      AppMethodBeat.i(103706);
      ab.i("DrawCanvasArg", "release %s", new Object[] { toString() });
      this.hfY = 0;
      this.hfX = 0;
      this.hfU = null;
      this.hfP = false;
      this.hfT = null;
      this.hfQ = null;
      this.hfR = 0L;
      this.hfS = false;
      this.hfV = false;
      this.hfW = false;
      Iterator localIterator = this.hfq.iterator();
      while (localIterator.hasNext())
      {
        DrawActionWrapper localDrawActionWrapper = (DrawActionWrapper)localIterator.next();
        if (localDrawActionWrapper != null) {
          localDrawActionWrapper.reset();
        }
        localIterator.remove();
      }
      com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d.ayb().hfu.release(this);
    }
    finally {}
    AppMethodBeat.o(103706);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void h(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103704);
    int i = 0;
    DrawActionWrapper localDrawActionWrapper;
    if ((i < paramJSONArray.length()) && (!this.hfV))
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      BaseDrawActionArg localBaseDrawActionArg = c.aya().zA(localJSONObject.optString("method"));
      localDrawActionWrapper = (DrawActionWrapper)com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d.ayb().hfv.acquire();
      localObject = localDrawActionWrapper;
      if (localDrawActionWrapper == null) {
        localObject = new DrawActionWrapper();
      }
      if (localBaseDrawActionArg != null)
      {
        ((DrawActionWrapper)localObject).type = 2;
        localBaseDrawActionArg.p(localJSONObject);
        ((DrawActionWrapper)localObject).heL = localBaseDrawActionArg;
      }
      for (;;)
      {
        this.hfq.add(localObject);
        i += 1;
        break;
        ((DrawActionWrapper)localObject).type = 1;
        ((DrawActionWrapper)localObject).heM = localJSONObject;
      }
    }
    paramJSONArray = new LinkedList();
    Object localObject = new ArrayList();
    this.hfY += this.hfq.size();
    int j = this.hfq.size() - 1;
    i = 0;
    if (j >= 0)
    {
      localDrawActionWrapper = (DrawActionWrapper)this.hfq.get(j);
      boolean bool;
      switch (localDrawActionWrapper.type)
      {
      default: 
        bool = false;
        label235:
        if (bool)
        {
          ab.i("DrawCanvasArg", "found redudant method %s", new Object[] { localDrawActionWrapper.getMethod() });
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
        break label235;
        bool = localDrawActionWrapper.heL.axX();
        break label235;
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
    this.hfX += ((List)localObject).size();
    paramJSONArray = ((List)localObject).iterator();
    while (paramJSONArray.hasNext())
    {
      localObject = (DrawActionWrapper)paramJSONArray.next();
      this.hfq.remove(localObject);
      ((DrawActionWrapper)localObject).reset();
    }
    ab.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", new Object[] { Integer.valueOf(this.hfX), Integer.valueOf(i), Integer.valueOf(this.hfY) });
    AppMethodBeat.o(103704);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103705);
    if ((this.hfU != null) && (!com.tencent.mm.sdk.g.d.ysm.remove(this.hfU)))
    {
      ab.i("DrawCanvasArg", "wait for async over");
      this.hfV = true;
      AppMethodBeat.o(103705);
      return;
    }
    release();
    AppMethodBeat.o(103705);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(103707);
    if (this.hfP)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hfQ);
      paramParcel.writeList(this.hfq);
      paramParcel.writeLong(this.hfR);
      if (!this.hfS) {
        break label72;
      }
    }
    label72:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(103707);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg
 * JD-Core Version:    0.7.0.1
 */