package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.platformtools.ad;
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
  public List<DrawActionWrapper> iZB;
  public boolean jaa;
  public String jab;
  public long jac;
  public boolean jad;
  public JSONArray jae;
  public volatile b jaf;
  private volatile boolean jag;
  public volatile boolean jah;
  protected volatile int jai;
  protected volatile int jaj;
  
  static
  {
    AppMethodBeat.i(145393);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145393);
  }
  
  public DrawCanvasArg()
  {
    AppMethodBeat.i(145385);
    this.iZB = new ArrayList();
    this.jag = false;
    this.jah = false;
    AppMethodBeat.o(145385);
  }
  
  public DrawCanvasArg(Parcel paramParcel)
  {
    AppMethodBeat.i(145386);
    this.iZB = new ArrayList();
    this.jag = false;
    this.jah = false;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jaa = bool1;
      this.jab = paramParcel.readString();
      this.iZB = paramParcel.readArrayList(DrawCanvasArg.class.getClassLoader());
      this.jac = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jad = bool1;
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
      ad.i("DrawCanvasArg", "release %s", new Object[] { toString() });
      this.jaj = 0;
      this.jai = 0;
      this.jaf = null;
      this.jaa = false;
      this.jae = null;
      this.jab = null;
      this.jac = 0L;
      this.jad = false;
      this.jag = false;
      this.jah = false;
      Iterator localIterator = this.iZB.iterator();
      while (localIterator.hasNext())
      {
        DrawActionWrapper localDrawActionWrapper = (DrawActionWrapper)localIterator.next();
        if (localDrawActionWrapper != null) {
          localDrawActionWrapper.reset();
        }
        localIterator.remove();
      }
      d.aSU().iZF.release(this);
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
    if ((i < paramJSONArray.length()) && (!this.jag))
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      BaseDrawActionArg localBaseDrawActionArg = com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c.aST().Fq(localJSONObject.optString("method"));
      localDrawActionWrapper = (DrawActionWrapper)d.aSU().iZG.acquire();
      localObject = localDrawActionWrapper;
      if (localDrawActionWrapper == null) {
        localObject = new DrawActionWrapper();
      }
      if (localBaseDrawActionArg != null)
      {
        ((DrawActionWrapper)localObject).type = 2;
        localBaseDrawActionArg.parse(localJSONObject);
        ((DrawActionWrapper)localObject).iYV = localBaseDrawActionArg;
      }
      for (;;)
      {
        this.iZB.add(localObject);
        i += 1;
        break;
        ((DrawActionWrapper)localObject).type = 1;
        ((DrawActionWrapper)localObject).iYW = localJSONObject;
      }
    }
    paramJSONArray = new LinkedList();
    Object localObject = new ArrayList();
    this.jaj += this.iZB.size();
    int j = this.iZB.size() - 1;
    i = 0;
    if (j >= 0)
    {
      localDrawActionWrapper = (DrawActionWrapper)this.iZB.get(j);
      boolean bool;
      switch (localDrawActionWrapper.type)
      {
      default: 
        bool = false;
        label235:
        if (bool)
        {
          ad.i("DrawCanvasArg", "found redudant method %s", new Object[] { localDrawActionWrapper.getMethod() });
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
        bool = localDrawActionWrapper.iYV.aSQ();
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
    this.jai += ((List)localObject).size();
    paramJSONArray = ((List)localObject).iterator();
    while (paramJSONArray.hasNext())
    {
      localObject = (DrawActionWrapper)paramJSONArray.next();
      this.iZB.remove(localObject);
      ((DrawActionWrapper)localObject).reset();
    }
    ad.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", new Object[] { Integer.valueOf(this.jai), Integer.valueOf(i), Integer.valueOf(this.jaj) });
    AppMethodBeat.o(145387);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145388);
    if ((this.jaf != null) && (!this.jaf.cancel()))
    {
      ad.i("DrawCanvasArg", "wait for async over");
      this.jag = true;
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
    if (this.jaa)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jab);
      paramParcel.writeList(this.iZB);
      paramParcel.writeLong(this.jac);
      if (!this.jad) {
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