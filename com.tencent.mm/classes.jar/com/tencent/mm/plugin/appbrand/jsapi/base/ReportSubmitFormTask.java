package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.cnh;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.protocal.c.gz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR = new ReportSubmitFormTask.2();
  public String appId;
  public int bFu;
  public String bUo;
  public int cau;
  public String gle;
  public int type;
  
  public ReportSubmitFormTask() {}
  
  public ReportSubmitFormTask(i parami)
  {
    this.appId = parami.appId;
    this.bFu = parami.aej();
    this.cau = parami.fPS.fEN;
  }
  
  private static LinkedList<cnh> aim()
  {
    localLinkedList = new LinkedList();
    Object localObject = (String)g.DP().Dz().get(ac.a.utJ, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        cnh localcnh = new cnh();
        localcnh.type = localJSONObject.getInt("type");
        localcnh.bOL = localJSONObject.getString("appid");
        localcnh.uaa = localJSONObject.getString("formid");
        localcnh.uab = localJSONObject.getString("pageid");
        localcnh.ham = localJSONObject.getInt("appstate");
        localcnh.han = localJSONObject.getInt("appversion");
        localLinkedList.add(localcnh);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      g.DP().Dz().c(ac.a.utJ, "");
    }
  }
  
  public final void Zu()
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new gy();
    ((b.a)localObject1).ecI = new gz();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((b.a)localObject1).ecG = 1129;
    localObject1 = ((b.a)localObject1).Kt();
    final gy localgy = (gy)((b)localObject1).ecE.ecN;
    localgy.sAC = new LinkedList();
    ??? = new cnh();
    ((cnh)???).type = this.type;
    ((cnh)???).bOL = this.appId;
    ((cnh)???).uaa = this.gle;
    ((cnh)???).uab = this.bUo;
    ((cnh)???).ham = this.bFu;
    ((cnh)???).han = this.cau;
    localgy.sAC.add(???);
    synchronized (getClass())
    {
      localgy.sAC.addAll(aim());
      w.a((b)localObject1, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, b paramAnonymousb, m paramAnonymousm)
        {
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {}
          synchronized (ReportSubmitFormTask.this.getClass())
          {
            ReportSubmitFormTask.x(localgy.sAC);
            y.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            return 0;
          }
        }
      });
      return;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.gle = paramParcel.readString();
    this.bUo = paramParcel.readString();
    this.bFu = paramParcel.readInt();
    this.cau = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.gle);
    paramParcel.writeString(this.bUo);
    paramParcel.writeInt(this.bFu);
    paramParcel.writeInt(this.cau);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */