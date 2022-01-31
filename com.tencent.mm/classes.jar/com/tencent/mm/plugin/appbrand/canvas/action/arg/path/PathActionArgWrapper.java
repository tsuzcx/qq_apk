package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathActionArgWrapper
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<PathActionArgWrapper> CREATOR;
  public List<BasePathActionArg> hfq;
  
  static
  {
    AppMethodBeat.i(103596);
    CREATOR = new PathActionArgWrapper.1();
    AppMethodBeat.o(103596);
  }
  
  public PathActionArgWrapper()
  {
    AppMethodBeat.i(103590);
    this.hfq = new ArrayList();
    AppMethodBeat.o(103590);
  }
  
  public PathActionArgWrapper(Parcel paramParcel)
  {
    this(paramParcel, (byte)0);
  }
  
  private PathActionArgWrapper(Parcel paramParcel, byte paramByte)
  {
    super(paramParcel);
    AppMethodBeat.i(103589);
    this.hfq = new ArrayList();
    this.hfq = paramParcel.readArrayList(PathActionArgWrapper.class.getClassLoader());
    AppMethodBeat.o(103589);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103594);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103594);
      return false;
    }
    if ((paramObject instanceof PathActionArgWrapper))
    {
      paramObject = (PathActionArgWrapper)paramObject;
      boolean bool = this.hfq.equals(paramObject.hfq);
      AppMethodBeat.o(103594);
      return bool;
    }
    AppMethodBeat.o(103594);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103592);
    super.h(paramParcel);
    AppMethodBeat.o(103592);
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103593);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      AppMethodBeat.o(103593);
      return;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      Object localObject = localJSONObject.optString("method");
      localObject = (BasePathActionArg)f.ayd().zA((String)localObject);
      ((BasePathActionArg)localObject).p(localJSONObject);
      this.hfq.add(localObject);
      i += 1;
    }
    AppMethodBeat.o(103593);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103591);
    super.reset();
    Iterator localIterator = this.hfq.iterator();
    while (localIterator.hasNext())
    {
      BasePathActionArg localBasePathActionArg = (BasePathActionArg)localIterator.next();
      f.ayd().a(localBasePathActionArg);
    }
    this.hfq.clear();
    AppMethodBeat.o(103591);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103595);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.hfq);
    AppMethodBeat.o(103595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper
 * JD-Core Version:    0.7.0.1
 */