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
  public List<BasePathActionArg> qTR;
  
  static
  {
    AppMethodBeat.i(145279);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145279);
  }
  
  public PathActionArgWrapper()
  {
    AppMethodBeat.i(145273);
    this.qTR = new ArrayList();
    AppMethodBeat.o(145273);
  }
  
  public PathActionArgWrapper(Parcel paramParcel)
  {
    this(paramParcel, (byte)0);
  }
  
  private PathActionArgWrapper(Parcel paramParcel, byte paramByte)
  {
    super(paramParcel);
    AppMethodBeat.i(145272);
    this.qTR = new ArrayList();
    this.qTR = paramParcel.readArrayList(PathActionArgWrapper.class.getClassLoader());
    AppMethodBeat.o(145272);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145277);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145277);
      return false;
    }
    if ((paramObject instanceof PathActionArgWrapper))
    {
      paramObject = (PathActionArgWrapper)paramObject;
      boolean bool = this.qTR.equals(paramObject.qTR);
      AppMethodBeat.o(145277);
      return bool;
    }
    AppMethodBeat.o(145277);
    return false;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145275);
    super.k(paramParcel);
    AppMethodBeat.o(145275);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145276);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      AppMethodBeat.o(145276);
      return;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      Object localObject = localJSONObject.optString("method");
      localObject = (BasePathActionArg)f.ckf().WQ((String)localObject);
      ((BasePathActionArg)localObject).parse(localJSONObject);
      this.qTR.add(localObject);
      i += 1;
    }
    AppMethodBeat.o(145276);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145274);
    super.reset();
    Iterator localIterator = this.qTR.iterator();
    while (localIterator.hasNext())
    {
      BasePathActionArg localBasePathActionArg = (BasePathActionArg)localIterator.next();
      f.ckf().a(localBasePathActionArg);
    }
    this.qTR.clear();
    AppMethodBeat.o(145274);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145278);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.qTR);
    AppMethodBeat.o(145278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper
 * JD-Core Version:    0.7.0.1
 */