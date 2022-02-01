package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.SynchronizedPool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.b;
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
  public List<DrawActionWrapper> qTR;
  public boolean qUq;
  public String qUr;
  public long qUs;
  public boolean qUt;
  public JSONArray qUu;
  public volatile b qUv;
  private volatile boolean qUw;
  public volatile boolean qUx;
  protected volatile int qUy;
  protected volatile int qUz;
  
  static
  {
    AppMethodBeat.i(145393);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145393);
  }
  
  public DrawCanvasArg()
  {
    AppMethodBeat.i(145385);
    this.qTR = new ArrayList();
    this.qUw = false;
    this.qUx = false;
    AppMethodBeat.o(145385);
  }
  
  public DrawCanvasArg(Parcel paramParcel)
  {
    AppMethodBeat.i(145386);
    this.qTR = new ArrayList();
    this.qUw = false;
    this.qUx = false;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.qUq = bool1;
      this.qUr = paramParcel.readString();
      this.qTR = paramParcel.readArrayList(DrawCanvasArg.class.getClassLoader());
      this.qUs = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qUt = bool1;
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
      this.qUz = 0;
      this.qUy = 0;
      this.qUv = null;
      this.qUq = false;
      this.qUu = null;
      this.qUr = null;
      this.qUs = 0L;
      this.qUt = false;
      this.qUw = false;
      this.qUx = false;
      Iterator localIterator = this.qTR.iterator();
      while (localIterator.hasNext())
      {
        DrawActionWrapper localDrawActionWrapper = (DrawActionWrapper)localIterator.next();
        if (localDrawActionWrapper != null) {
          localDrawActionWrapper.reset();
        }
        localIterator.remove();
      }
      d.ckd().qTV.release(this);
    }
    finally {}
    AppMethodBeat.o(145389);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void k(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145387);
    int i = 0;
    DrawActionWrapper localDrawActionWrapper;
    if ((i < paramJSONArray.length()) && (!this.qUw))
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      BaseDrawActionArg localBaseDrawActionArg = c.ckc().WQ(localJSONObject.optString("method"));
      localDrawActionWrapper = (DrawActionWrapper)d.ckd().qTW.acquire();
      localObject = localDrawActionWrapper;
      if (localDrawActionWrapper == null) {
        localObject = new DrawActionWrapper();
      }
      if (localBaseDrawActionArg != null)
      {
        ((DrawActionWrapper)localObject).type = 2;
        localBaseDrawActionArg.parse(localJSONObject);
        ((DrawActionWrapper)localObject).qTs = localBaseDrawActionArg;
      }
      for (;;)
      {
        this.qTR.add(localObject);
        i += 1;
        break;
        ((DrawActionWrapper)localObject).type = 1;
        ((DrawActionWrapper)localObject).qTt = localJSONObject;
      }
    }
    paramJSONArray = new LinkedList();
    Object localObject = new ArrayList();
    this.qUz += this.qTR.size();
    int j = this.qTR.size() - 1;
    i = 0;
    if (j >= 0)
    {
      localDrawActionWrapper = (DrawActionWrapper)this.qTR.get(j);
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
        bool = localDrawActionWrapper.qTs.cjZ();
        break label235;
        if ("save".equals(localDrawActionWrapper.getMethod()))
        {
          if ((paramJSONArray.size() > 0) && (((DrawActionWrapper)paramJSONArray.getLast()).getMethod().equals("restore")))
          {
            ((List)localObject).add(localDrawActionWrapper);
            ((List)localObject).add((DrawActionWrapper)paramJSONArray.removeLast());
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
    this.qUy += ((List)localObject).size();
    paramJSONArray = ((List)localObject).iterator();
    while (paramJSONArray.hasNext())
    {
      localObject = (DrawActionWrapper)paramJSONArray.next();
      this.qTR.remove(localObject);
      ((DrawActionWrapper)localObject).reset();
    }
    Log.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", new Object[] { Integer.valueOf(this.qUy), Integer.valueOf(i), Integer.valueOf(this.qUz) });
    AppMethodBeat.o(145387);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145388);
    if ((this.qUv != null) && (!this.qUv.cancel()))
    {
      Log.i("DrawCanvasArg", "wait for async over");
      this.qUw = true;
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
    if (this.qUq)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.qUr);
      paramParcel.writeList(this.qTR);
      paramParcel.writeLong(this.qUs);
      if (!this.qUt) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg
 * JD-Core Version:    0.7.0.1
 */