package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.fpx;
import com.tencent.mm.protocal.protobuf.ko;
import com.tencent.mm.protocal.protobuf.kp;
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
  public int fvc;
  public String oGs;
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
    this.fvc = paraml.nYR.nHY;
    this.appVersion = paraml.nYR.pkgVersion;
  }
  
  private static LinkedList<fpx> bQD()
  {
    AppMethodBeat.i(46141);
    localLinkedList = new LinkedList();
    Object localObject = (String)h.aHG().aHp().get(ar.a.VmR, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        fpx localfpx = new fpx();
        localfpx.type = localJSONObject.getInt("type");
        localfpx.appid = localJSONObject.getString("appid");
        localfpx.UNM = localJSONObject.getString("formid");
        localfpx.UNN = localJSONObject.getString("pageid");
        localfpx.qLQ = localJSONObject.getInt("appstate");
        localfpx.qNx = localJSONObject.getInt("appversion");
        localLinkedList.add(localfpx);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      h.aHG().aHp().set(ar.a.VmR, "");
      AppMethodBeat.o(46141);
    }
  }
  
  public final void RW()
  {
    AppMethodBeat.i(46140);
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new ko();
    ((d.a)localObject1).lBV = new kp();
    ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((d.a)localObject1).funcId = 1129;
    localObject1 = ((d.a)localObject1).bgN();
    final ko localko = (ko)d.b.b(((d)localObject1).lBR);
    localko.RPO = new LinkedList();
    ??? = new fpx();
    ((fpx)???).type = this.type;
    ((fpx)???).appid = this.appId;
    ((fpx)???).UNM = this.oGs;
    ((fpx)???).UNN = this.pageId;
    ((fpx)???).qLQ = this.fvc;
    ((fpx)???).qNx = this.appVersion;
    localko.RPO.add(???);
    synchronized (getClass())
    {
      localko.RPO.addAll(bQD());
      aa.a((d)localObject1, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(46138);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            synchronized (ReportSubmitFormTask.this.getClass())
            {
              ReportSubmitFormTask.A(localko.RPO);
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
    this.oGs = paramParcel.readString();
    this.pageId = paramParcel.readString();
    this.fvc = paramParcel.readInt();
    this.appVersion = paramParcel.readInt();
    AppMethodBeat.o(46143);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46142);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.oGs);
    paramParcel.writeString(this.pageId);
    paramParcel.writeInt(this.fvc);
    paramParcel.writeInt(this.appVersion);
    AppMethodBeat.o(46142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */