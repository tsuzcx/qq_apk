package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.few;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR;
  public String appId;
  public int appVersion;
  public int dCv;
  public String lKc;
  public String pageId;
  public int type;
  
  static
  {
    AppMethodBeat.i(46145);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46145);
  }
  
  public ReportSubmitFormTask() {}
  
  public ReportSubmitFormTask(l paraml)
  {
    this.appId = paraml.appId;
    this.dCv = paraml.leE.kNW;
    this.appVersion = paraml.leE.pkgVersion;
  }
  
  private static LinkedList<few> bEZ()
  {
    AppMethodBeat.i(46141);
    localLinkedList = new LinkedList();
    Object localObject = (String)g.aAh().azQ().get(ar.a.NYR, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        few localfew = new few();
        localfew.type = localJSONObject.getInt("type");
        localfew.dNI = localJSONObject.getString("appid");
        localfew.NAk = localJSONObject.getString("formid");
        localfew.NAl = localJSONObject.getString("pageid");
        localfew.nJE = localJSONObject.getInt("appstate");
        localfew.nLk = localJSONObject.getInt("appversion");
        localLinkedList.add(localfew);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      g.aAh().azQ().set(ar.a.NYR, "");
      AppMethodBeat.o(46141);
    }
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(46140);
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new ky();
    ((d.a)localObject1).iLO = new kz();
    ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((d.a)localObject1).funcId = 1129;
    localObject1 = ((d.a)localObject1).aXF();
    final ky localky = (ky)((d)localObject1).iLK.iLR;
    localky.KOQ = new LinkedList();
    ??? = new few();
    ((few)???).type = this.type;
    ((few)???).dNI = this.appId;
    ((few)???).NAk = this.lKc;
    ((few)???).NAl = this.pageId;
    ((few)???).nJE = this.dCv;
    ((few)???).nLk = this.appVersion;
    localky.KOQ.add(???);
    synchronized (getClass())
    {
      localky.KOQ.addAll(bEZ());
      aa.a((d)localObject1, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(46138);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            synchronized (ReportSubmitFormTask.this.getClass())
            {
              ReportSubmitFormTask.z(localky.KOQ);
              Log.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(46143);
    this.type = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.lKc = paramParcel.readString();
    this.pageId = paramParcel.readString();
    this.dCv = paramParcel.readInt();
    this.appVersion = paramParcel.readInt();
    AppMethodBeat.o(46143);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46142);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.lKc);
    paramParcel.writeString(this.pageId);
    paramParcel.writeInt(this.dCv);
    paramParcel.writeInt(this.appVersion);
    AppMethodBeat.o(46142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */