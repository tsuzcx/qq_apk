package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR;
  public int aDD;
  public String appId;
  public int dli;
  public String kFB;
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
    this.dli = paramk.kbw.jLV;
    this.aDD = paramk.kbw.pkgVersion;
  }
  
  private static LinkedList<ekd> bjJ()
  {
    AppMethodBeat.i(46141);
    localLinkedList = new LinkedList();
    Object localObject = (String)g.ajR().ajA().get(am.a.IQP, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        ekd localekd = new ekd();
        localekd.type = localJSONObject.getInt("type");
        localekd.dwb = localJSONObject.getString("appid");
        localekd.Ini = localJSONObject.getString("formid");
        localekd.Inj = localJSONObject.getString("pageid");
        localekd.myD = localJSONObject.getInt("appstate");
        localekd.mAf = localJSONObject.getInt("appversion");
        localLinkedList.add(localekd);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      g.ajR().ajA().set(am.a.IQP, "");
      AppMethodBeat.o(46141);
    }
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(46140);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new kh();
    ((b.a)localObject1).hQG = new ki();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((b.a)localObject1).funcId = 1129;
    localObject1 = ((b.a)localObject1).aDS();
    final kh localkh = (kh)((b)localObject1).hQD.hQJ;
    localkh.FVf = new LinkedList();
    ??? = new ekd();
    ((ekd)???).type = this.type;
    ((ekd)???).dwb = this.appId;
    ((ekd)???).Ini = this.kFB;
    ((ekd)???).Inj = this.pageId;
    ((ekd)???).myD = this.dli;
    ((ekd)???).mAf = this.aDD;
    localkh.FVf.add(???);
    synchronized (getClass())
    {
      localkh.FVf.addAll(bjJ());
      x.a((b)localObject1, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(46138);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            synchronized (ReportSubmitFormTask.this.getClass())
            {
              ReportSubmitFormTask.z(localkh.FVf);
              ae.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
    this.kFB = paramParcel.readString();
    this.pageId = paramParcel.readString();
    this.dli = paramParcel.readInt();
    this.aDD = paramParcel.readInt();
    AppMethodBeat.o(46143);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46142);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.kFB);
    paramParcel.writeString(this.pageId);
    paramParcel.writeInt(this.dli);
    paramParcel.writeInt(this.aDD);
    AppMethodBeat.o(46142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */