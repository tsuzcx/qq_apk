package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.platformtools.ae;
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
  public String jXA;
  public long jXB;
  public boolean jXC;
  public JSONArray jXD;
  public volatile b jXE;
  private volatile boolean jXF;
  public volatile boolean jXG;
  protected volatile int jXH;
  protected volatile int jXI;
  public List<DrawActionWrapper> jXa;
  public boolean jXz;
  
  static
  {
    AppMethodBeat.i(145393);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145393);
  }
  
  public DrawCanvasArg()
  {
    AppMethodBeat.i(145385);
    this.jXa = new ArrayList();
    this.jXF = false;
    this.jXG = false;
    AppMethodBeat.o(145385);
  }
  
  public DrawCanvasArg(Parcel paramParcel)
  {
    AppMethodBeat.i(145386);
    this.jXa = new ArrayList();
    this.jXF = false;
    this.jXG = false;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jXz = bool1;
      this.jXA = paramParcel.readString();
      this.jXa = paramParcel.readArrayList(DrawCanvasArg.class.getClassLoader());
      this.jXB = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jXC = bool1;
      AppMethodBeat.o(145386);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void release()
  {
    try
    {
      AppMethodBeat.i(145389);
      ae.i("DrawCanvasArg", "release %s", new Object[] { toString() });
      this.jXI = 0;
      this.jXH = 0;
      this.jXE = null;
      this.jXz = false;
      this.jXD = null;
      this.jXA = null;
      this.jXB = 0L;
      this.jXC = false;
      this.jXF = false;
      this.jXG = false;
      Iterator localIterator = this.jXa.iterator();
      while (localIterator.hasNext())
      {
        DrawActionWrapper localDrawActionWrapper = (DrawActionWrapper)localIterator.next();
        if (localDrawActionWrapper != null) {
          localDrawActionWrapper.reset();
        }
        localIterator.remove();
      }
      d.bdX().jXe.release(this);
    }
    finally {}
    AppMethodBeat.o(145389);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void h(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145387);
    int i = 0;
    DrawActionWrapper localDrawActionWrapper;
    if ((i < paramJSONArray.length()) && (!this.jXF))
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      BaseDrawActionArg localBaseDrawActionArg = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c.bdW().Nu(localJSONObject.optString("method"));
      localDrawActionWrapper = (DrawActionWrapper)d.bdX().jXf.acquire();
      localObject = localDrawActionWrapper;
      if (localDrawActionWrapper == null) {
        localObject = new DrawActionWrapper();
      }
      if (localBaseDrawActionArg != null)
      {
        ((DrawActionWrapper)localObject).type = 2;
        localBaseDrawActionArg.parse(localJSONObject);
        ((DrawActionWrapper)localObject).jWz = localBaseDrawActionArg;
      }
      for (;;)
      {
        this.jXa.add(localObject);
        i += 1;
        break;
        ((DrawActionWrapper)localObject).type = 1;
        ((DrawActionWrapper)localObject).jWA = localJSONObject;
      }
    }
    paramJSONArray = new LinkedList();
    Object localObject = new ArrayList();
    this.jXI += this.jXa.size();
    int j = this.jXa.size() - 1;
    i = 0;
    if (j >= 0)
    {
      localDrawActionWrapper = (DrawActionWrapper)this.jXa.get(j);
      boolean bool;
      switch (localDrawActionWrapper.type)
      {
      default: 
        bool = false;
        label235:
        if (bool)
        {
          ae.i("DrawCanvasArg", "found redudant method %s", new Object[] { localDrawActionWrapper.getMethod() });
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
        bool = localDrawActionWrapper.jWz.bdT();
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
    this.jXH += ((List)localObject).size();
    paramJSONArray = ((List)localObject).iterator();
    while (paramJSONArray.hasNext())
    {
      localObject = (DrawActionWrapper)paramJSONArray.next();
      this.jXa.remove(localObject);
      ((DrawActionWrapper)localObject).reset();
    }
    ae.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", new Object[] { Integer.valueOf(this.jXH), Integer.valueOf(i), Integer.valueOf(this.jXI) });
    AppMethodBeat.o(145387);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145388);
    if ((this.jXE != null) && (!this.jXE.cancel()))
    {
      ae.i("DrawCanvasArg", "wait for async over");
      this.jXF = true;
      AppMethodBeat.o(145388);
      return;
    }
    release();
    AppMethodBeat.o(145388);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(145390);
    if (this.jXz)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jXA);
      paramParcel.writeList(this.jXa);
      paramParcel.writeLong(this.jXB);
      if (!this.jXC) {
        break label72;
      }
    }
    label72:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(145390);
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