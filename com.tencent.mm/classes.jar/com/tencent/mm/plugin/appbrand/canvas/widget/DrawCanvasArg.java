package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.SynchronizedPool;
import com.tencent.mm.sdk.platformtools.Log;
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
  public List<DrawActionWrapper> kZW;
  public boolean laA;
  public JSONArray laB;
  public volatile b laC;
  private volatile boolean laD;
  public volatile boolean laE;
  protected volatile int laF;
  protected volatile int laG;
  public boolean lax;
  public String lay;
  public long laz;
  
  static
  {
    AppMethodBeat.i(145393);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145393);
  }
  
  public DrawCanvasArg()
  {
    AppMethodBeat.i(145385);
    this.kZW = new ArrayList();
    this.laD = false;
    this.laE = false;
    AppMethodBeat.o(145385);
  }
  
  public DrawCanvasArg(Parcel paramParcel)
  {
    AppMethodBeat.i(145386);
    this.kZW = new ArrayList();
    this.laD = false;
    this.laE = false;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.lax = bool1;
      this.lay = paramParcel.readString();
      this.kZW = paramParcel.readArrayList(DrawCanvasArg.class.getClassLoader());
      this.laz = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.laA = bool1;
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
      Log.i("DrawCanvasArg", "release %s", new Object[] { toString() });
      this.laG = 0;
      this.laF = 0;
      this.laC = null;
      this.lax = false;
      this.laB = null;
      this.lay = null;
      this.laz = 0L;
      this.laA = false;
      this.laD = false;
      this.laE = false;
      Iterator localIterator = this.kZW.iterator();
      while (localIterator.hasNext())
      {
        DrawActionWrapper localDrawActionWrapper = (DrawActionWrapper)localIterator.next();
        if (localDrawActionWrapper != null) {
          localDrawActionWrapper.reset();
        }
        localIterator.remove();
      }
      d.bzo().laa.release(this);
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
    if ((i < paramJSONArray.length()) && (!this.laD))
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      BaseDrawActionArg localBaseDrawActionArg = c.bzn().WC(localJSONObject.optString("method"));
      localDrawActionWrapper = (DrawActionWrapper)d.bzo().lab.acquire();
      localObject = localDrawActionWrapper;
      if (localDrawActionWrapper == null) {
        localObject = new DrawActionWrapper();
      }
      if (localBaseDrawActionArg != null)
      {
        ((DrawActionWrapper)localObject).type = 2;
        localBaseDrawActionArg.parse(localJSONObject);
        ((DrawActionWrapper)localObject).kZv = localBaseDrawActionArg;
      }
      for (;;)
      {
        this.kZW.add(localObject);
        i += 1;
        break;
        ((DrawActionWrapper)localObject).type = 1;
        ((DrawActionWrapper)localObject).kZw = localJSONObject;
      }
    }
    paramJSONArray = new LinkedList();
    Object localObject = new ArrayList();
    this.laG += this.kZW.size();
    int j = this.kZW.size() - 1;
    i = 0;
    if (j >= 0)
    {
      localDrawActionWrapper = (DrawActionWrapper)this.kZW.get(j);
      boolean bool;
      switch (localDrawActionWrapper.type)
      {
      default: 
        bool = false;
        label235:
        if (bool)
        {
          Log.i("DrawCanvasArg", "found redudant method %s", new Object[] { localDrawActionWrapper.getMethod() });
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
        bool = localDrawActionWrapper.kZv.bzk();
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
    this.laF += ((List)localObject).size();
    paramJSONArray = ((List)localObject).iterator();
    while (paramJSONArray.hasNext())
    {
      localObject = (DrawActionWrapper)paramJSONArray.next();
      this.kZW.remove(localObject);
      ((DrawActionWrapper)localObject).reset();
    }
    Log.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", new Object[] { Integer.valueOf(this.laF), Integer.valueOf(i), Integer.valueOf(this.laG) });
    AppMethodBeat.o(145387);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145388);
    if ((this.laC != null) && (!this.laC.cancel()))
    {
      Log.i("DrawCanvasArg", "wait for async over");
      this.laD = true;
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
    if (this.lax)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.lay);
      paramParcel.writeList(this.kZW);
      paramParcel.writeLong(this.laz);
      if (!this.laA) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg
 * JD-Core Version:    0.7.0.1
 */