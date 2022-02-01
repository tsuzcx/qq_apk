package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.gna;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR;
  public String appId;
  public int appVersion;
  public String hUf;
  public int hzw;
  public String rJr;
  public int type;
  
  static
  {
    AppMethodBeat.i(46145);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46145);
  }
  
  public ReportSubmitFormTask() {}
  
  public ReportSubmitFormTask(n paramn)
  {
    this.appId = paramn.appId;
    this.hzw = paramn.qYY.qHO;
    this.appVersion = paramn.qYY.pkgVersion;
  }
  
  private static LinkedList<gna> cqA()
  {
    AppMethodBeat.i(46141);
    localLinkedList = new LinkedList();
    Object localObject = (String)h.baE().ban().get(at.a.acOm, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        gna localgna = new gna();
        localgna.type = localJSONObject.getInt("type");
        localgna.appid = localJSONObject.getString("appid");
        localgna.acij = localJSONObject.getString("formid");
        localgna.acik = localJSONObject.getString("pageid");
        localgna.tQx = localJSONObject.getInt("appstate");
        localgna.tSh = localJSONObject.getInt("appversion");
        localLinkedList.add(localgna);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      h.baE().ban().set(at.a.acOm, "");
      AppMethodBeat.o(46141);
    }
  }
  
  public final void asn()
  {
    AppMethodBeat.i(46140);
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new lk();
    ((c.a)localObject1).otF = new ll();
    ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((c.a)localObject1).funcId = 1129;
    localObject1 = ((c.a)localObject1).bEF();
    final lk locallk = (lk)c.b.b(((c)localObject1).otB);
    locallk.YNc = new LinkedList();
    ??? = new gna();
    ((gna)???).type = this.type;
    ((gna)???).appid = this.appId;
    ((gna)???).acij = this.rJr;
    ((gna)???).acik = this.hUf;
    ((gna)???).tQx = this.hzw;
    ((gna)???).tSh = this.appVersion;
    locallk.YNc.add(???);
    synchronized (getClass())
    {
      locallk.YNc.addAll(cqA());
      z.a((c)localObject1, new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(46138);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            synchronized (ReportSubmitFormTask.this.getClass())
            {
              ReportSubmitFormTask.D(locallk.YNc);
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
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(46143);
    this.type = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.rJr = paramParcel.readString();
    this.hUf = paramParcel.readString();
    this.hzw = paramParcel.readInt();
    this.appVersion = paramParcel.readInt();
    AppMethodBeat.o(46143);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46142);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.rJr);
    paramParcel.writeString(this.hUf);
    paramParcel.writeInt(this.hzw);
    paramParcel.writeInt(this.appVersion);
    AppMethodBeat.o(46142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */