package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.platformtools.ac;
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
  public boolean jAn;
  public String jAo;
  public long jAp;
  public boolean jAq;
  public JSONArray jAr;
  public volatile b jAs;
  private volatile boolean jAt;
  public volatile boolean jAu;
  protected volatile int jAv;
  protected volatile int jAw;
  public List<DrawActionWrapper> jzO;
  
  static
  {
    AppMethodBeat.i(145393);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145393);
  }
  
  public DrawCanvasArg()
  {
    AppMethodBeat.i(145385);
    this.jzO = new ArrayList();
    this.jAt = false;
    this.jAu = false;
    AppMethodBeat.o(145385);
  }
  
  public DrawCanvasArg(Parcel paramParcel)
  {
    AppMethodBeat.i(145386);
    this.jzO = new ArrayList();
    this.jAt = false;
    this.jAu = false;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jAn = bool1;
      this.jAo = paramParcel.readString();
      this.jzO = paramParcel.readArrayList(DrawCanvasArg.class.getClassLoader());
      this.jAp = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jAq = bool1;
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
      ac.i("DrawCanvasArg", "release %s", new Object[] { toString() });
      this.jAw = 0;
      this.jAv = 0;
      this.jAs = null;
      this.jAn = false;
      this.jAr = null;
      this.jAo = null;
      this.jAp = 0L;
      this.jAq = false;
      this.jAt = false;
      this.jAu = false;
      Iterator localIterator = this.jzO.iterator();
      while (localIterator.hasNext())
      {
        DrawActionWrapper localDrawActionWrapper = (DrawActionWrapper)localIterator.next();
        if (localDrawActionWrapper != null) {
          localDrawActionWrapper.reset();
        }
        localIterator.remove();
      }
      d.aZT().jzS.release(this);
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
    if ((i < paramJSONArray.length()) && (!this.jAt))
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      BaseDrawActionArg localBaseDrawActionArg = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c.aZS().Ju(localJSONObject.optString("method"));
      localDrawActionWrapper = (DrawActionWrapper)d.aZT().jzT.acquire();
      localObject = localDrawActionWrapper;
      if (localDrawActionWrapper == null) {
        localObject = new DrawActionWrapper();
      }
      if (localBaseDrawActionArg != null)
      {
        ((DrawActionWrapper)localObject).type = 2;
        localBaseDrawActionArg.parse(localJSONObject);
        ((DrawActionWrapper)localObject).jzl = localBaseDrawActionArg;
      }
      for (;;)
      {
        this.jzO.add(localObject);
        i += 1;
        break;
        ((DrawActionWrapper)localObject).type = 1;
        ((DrawActionWrapper)localObject).jzm = localJSONObject;
      }
    }
    paramJSONArray = new LinkedList();
    Object localObject = new ArrayList();
    this.jAw += this.jzO.size();
    int j = this.jzO.size() - 1;
    i = 0;
    if (j >= 0)
    {
      localDrawActionWrapper = (DrawActionWrapper)this.jzO.get(j);
      boolean bool;
      switch (localDrawActionWrapper.type)
      {
      default: 
        bool = false;
        label235:
        if (bool)
        {
          ac.i("DrawCanvasArg", "found redudant method %s", new Object[] { localDrawActionWrapper.getMethod() });
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
        bool = localDrawActionWrapper.jzl.aZP();
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
    this.jAv += ((List)localObject).size();
    paramJSONArray = ((List)localObject).iterator();
    while (paramJSONArray.hasNext())
    {
      localObject = (DrawActionWrapper)paramJSONArray.next();
      this.jzO.remove(localObject);
      ((DrawActionWrapper)localObject).reset();
    }
    ac.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", new Object[] { Integer.valueOf(this.jAv), Integer.valueOf(i), Integer.valueOf(this.jAw) });
    AppMethodBeat.o(145387);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145388);
    if ((this.jAs != null) && (!this.jAs.cancel()))
    {
      ac.i("DrawCanvasArg", "wait for async over");
      this.jAt = true;
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
    if (this.jAn)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jAo);
      paramParcel.writeList(this.jzO);
      paramParcel.writeLong(this.jAp);
      if (!this.jAq) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg
 * JD-Core Version:    0.7.0.1
 */