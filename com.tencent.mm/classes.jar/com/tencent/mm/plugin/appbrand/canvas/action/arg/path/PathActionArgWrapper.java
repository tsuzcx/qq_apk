package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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
  public static final Parcelable.Creator<PathActionArgWrapper> CREATOR = new PathActionArgWrapper.1();
  public List<BasePathActionArg> fMg = new ArrayList();
  
  public PathActionArgWrapper() {}
  
  public PathActionArgWrapper(Parcel paramParcel)
  {
    this(paramParcel, (byte)0);
  }
  
  private PathActionArgWrapper(Parcel paramParcel, byte paramByte)
  {
    super(paramParcel);
    this.fMg = paramParcel.readArrayList(PathActionArgWrapper.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!super.equals(paramObject)) {}
    while (!(paramObject instanceof PathActionArgWrapper)) {
      return false;
    }
    paramObject = (PathActionArgWrapper)paramObject;
    return this.fMg.equals(paramObject.fMg);
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        Object localObject = localJSONObject.optString("method");
        localObject = (BasePathActionArg)f.adL().rK((String)localObject);
        ((BasePathActionArg)localObject).j(localJSONObject);
        this.fMg.add(localObject);
        i += 1;
      }
    }
  }
  
  public final void reset()
  {
    super.reset();
    Iterator localIterator = this.fMg.iterator();
    while (localIterator.hasNext())
    {
      BasePathActionArg localBasePathActionArg = (BasePathActionArg)localIterator.next();
      f.adL().a(localBasePathActionArg);
    }
    this.fMg.clear();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.fMg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper
 * JD-Core Version:    0.7.0.1
 */