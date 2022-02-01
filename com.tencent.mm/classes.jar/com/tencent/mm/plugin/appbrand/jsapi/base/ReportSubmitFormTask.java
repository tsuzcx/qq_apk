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
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR;
  public int aDD;
  public String appId;
  public int dkg;
  public String kCm;
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
    this.dkg = paramk.jYh.jIU;
    this.aDD = paramk.jYh.pkgVersion;
  }
  
  private static LinkedList<eim> bja()
  {
    AppMethodBeat.i(46141);
    localLinkedList = new LinkedList();
    Object localObject = (String)g.ajC().ajl().get(al.a.Iwr, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        eim localeim = new eim();
        localeim.type = localJSONObject.getInt("type");
        localeim.duW = localJSONObject.getString("appid");
        localeim.HTb = localJSONObject.getString("formid");
        localeim.HTc = localJSONObject.getString("pageid");
        localeim.mtG = localJSONObject.getInt("appstate");
        localeim.mvi = localJSONObject.getInt("appversion");
        localLinkedList.add(localeim);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      g.ajC().ajl().set(al.a.Iwr, "");
      AppMethodBeat.o(46141);
    }
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(46140);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new kh();
    ((b.a)localObject1).hNN = new ki();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((b.a)localObject1).funcId = 1129;
    localObject1 = ((b.a)localObject1).aDC();
    final kh localkh = (kh)((b)localObject1).hNK.hNQ;
    localkh.FCK = new LinkedList();
    ??? = new eim();
    ((eim)???).type = this.type;
    ((eim)???).duW = this.appId;
    ((eim)???).HTb = this.kCm;
    ((eim)???).HTc = this.pageId;
    ((eim)???).mtG = this.dkg;
    ((eim)???).mvi = this.aDD;
    localkh.FCK.add(???);
    synchronized (getClass())
    {
      localkh.FCK.addAll(bja());
      x.a((b)localObject1, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(46138);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            synchronized (ReportSubmitFormTask.this.getClass())
            {
              ReportSubmitFormTask.z(localkh.FCK);
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
    this.kCm = paramParcel.readString();
    this.pageId = paramParcel.readString();
    this.dkg = paramParcel.readInt();
    this.aDD = paramParcel.readInt();
    AppMethodBeat.o(46143);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46142);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.kCm);
    paramParcel.writeString(this.pageId);
    paramParcel.writeInt(this.dkg);
    paramParcel.writeInt(this.aDD);
    AppMethodBeat.o(46142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */