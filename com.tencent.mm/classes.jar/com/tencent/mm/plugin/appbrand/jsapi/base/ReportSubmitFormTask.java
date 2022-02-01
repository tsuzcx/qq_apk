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
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR;
  public int aBM;
  public String appId;
  public int cYO;
  public String khv;
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
    this.cYO = paramk.jEg.jpa;
    this.aBM = paramk.jEg.pkgVersion;
  }
  
  private static LinkedList<ecg> bfx()
  {
    AppMethodBeat.i(46141);
    localLinkedList = new LinkedList();
    Object localObject = (String)g.agR().agA().get(ah.a.GJZ, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        ecg localecg = new ecg();
        localecg.type = localJSONObject.getInt("type");
        localecg.djj = localJSONObject.getString("appid");
        localecg.GhN = localJSONObject.getString("formid");
        localecg.GhO = localJSONObject.getString("pageid");
        localecg.lTR = localJSONObject.getInt("appstate");
        localecg.lVs = localJSONObject.getInt("appversion");
        localLinkedList.add(localecg);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      g.agR().agA().set(ah.a.GJZ, "");
      AppMethodBeat.o(46141);
    }
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(46140);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new jy();
    ((b.a)localObject1).hvu = new jz();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((b.a)localObject1).funcId = 1129;
    localObject1 = ((b.a)localObject1).aAz();
    final jy localjy = (jy)((b)localObject1).hvr.hvw;
    localjy.DXo = new LinkedList();
    ??? = new ecg();
    ((ecg)???).type = this.type;
    ((ecg)???).djj = this.appId;
    ((ecg)???).GhN = this.khv;
    ((ecg)???).GhO = this.pageId;
    ((ecg)???).lTR = this.cYO;
    ((ecg)???).lVs = this.aBM;
    localjy.DXo.add(???);
    synchronized (getClass())
    {
      localjy.DXo.addAll(bfx());
      x.a((b)localObject1, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(46138);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            synchronized (ReportSubmitFormTask.this.getClass())
            {
              ReportSubmitFormTask.z(localjy.DXo);
              ac.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
    this.khv = paramParcel.readString();
    this.pageId = paramParcel.readString();
    this.cYO = paramParcel.readInt();
    this.aBM = paramParcel.readInt();
    AppMethodBeat.o(46143);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46142);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.khv);
    paramParcel.writeString(this.pageId);
    paramParcel.writeInt(this.cYO);
    paramParcel.writeInt(this.aBM);
    AppMethodBeat.o(46142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */