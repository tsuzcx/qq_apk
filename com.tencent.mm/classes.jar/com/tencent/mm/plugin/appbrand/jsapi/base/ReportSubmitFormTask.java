package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR;
  public int aAS;
  public String appId;
  public int dbs;
  public String jGW;
  public String pageId;
  public int type;
  
  static
  {
    AppMethodBeat.i(46145);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46145);
  }
  
  public ReportSubmitFormTask() {}
  
  public ReportSubmitFormTask(k paramk)
  {
    this.appId = paramk.appId;
    this.dbs = paramk.jdS.iOQ;
    this.aAS = paramk.jdS.pkgVersion;
  }
  
  private static LinkedList<dwp> aYA()
  {
    AppMethodBeat.i(46141);
    localLinkedList = new LinkedList();
    Object localObject = (String)g.afB().afk().get(ae.a.Fmk, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        dwp localdwp = new dwp();
        localdwp.type = localJSONObject.getInt("type");
        localdwp.dlB = localJSONObject.getString("appid");
        localdwp.EKB = localJSONObject.getString("formid");
        localdwp.EKC = localJSONObject.getString("pageid");
        localdwp.lrW = localJSONObject.getInt("appstate");
        localdwp.lty = localJSONObject.getInt("appversion");
        localLinkedList.add(localdwp);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      g.afB().afk().set(ae.a.Fmk, "");
      AppMethodBeat.o(46141);
    }
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(46140);
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new js();
    ((b.a)localObject1).gUV = new jt();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((b.a)localObject1).funcId = 1129;
    localObject1 = ((b.a)localObject1).atI();
    final js localjs = (js)((b)localObject1).gUS.gUX;
    localjs.CEO = new LinkedList();
    ??? = new dwp();
    ((dwp)???).type = this.type;
    ((dwp)???).dlB = this.appId;
    ((dwp)???).EKB = this.jGW;
    ((dwp)???).EKC = this.pageId;
    ((dwp)???).lrW = this.dbs;
    ((dwp)???).lty = this.aAS;
    localjs.CEO.add(???);
    synchronized (getClass())
    {
      localjs.CEO.addAll(aYA());
      x.a((b)localObject1, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(46138);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            synchronized (ReportSubmitFormTask.this.getClass())
            {
              ReportSubmitFormTask.z(localjs.CEO);
              ad.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(46138);
              return 0;
            }
          }
          AppMethodBeat.o(46138);
          return 0;
        }
      });
      AppMethodBeat.o(46140);
      return;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(46143);
    this.type = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.jGW = paramParcel.readString();
    this.pageId = paramParcel.readString();
    this.dbs = paramParcel.readInt();
    this.aAS = paramParcel.readInt();
    AppMethodBeat.o(46143);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46142);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.jGW);
    paramParcel.writeString(this.pageId);
    paramParcel.writeInt(this.dbs);
    paramParcel.writeInt(this.aAS);
    AppMethodBeat.o(46142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */