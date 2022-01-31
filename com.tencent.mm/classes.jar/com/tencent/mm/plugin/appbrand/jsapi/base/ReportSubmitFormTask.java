package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR;
  public String appId;
  public int bDc;
  public int cmE;
  public String hEU;
  public String pageId;
  public int type;
  
  static
  {
    AppMethodBeat.i(130908);
    CREATOR = new ReportSubmitFormTask.2();
    AppMethodBeat.o(130908);
  }
  
  public ReportSubmitFormTask() {}
  
  public ReportSubmitFormTask(h paramh)
  {
    this.appId = paramh.appId;
    this.cmE = paramh.hiX.gXe;
    this.bDc = paramh.hiX.gXf;
  }
  
  private static LinkedList<dbp> aCf()
  {
    AppMethodBeat.i(130904);
    localLinkedList = new LinkedList();
    Object localObject = (String)g.RL().Ru().get(ac.a.yDM, null);
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        dbp localdbp = new dbp();
        localdbp.type = localJSONObject.getInt("type");
        localdbp.cwc = localJSONObject.getString("appid");
        localdbp.yhT = localJSONObject.getString("formid");
        localdbp.yhU = localJSONObject.getString("pageid");
        localdbp.iIF = localJSONObject.getInt("appstate");
        localdbp.iIG = localJSONObject.getInt("appversion");
        localLinkedList.add(localdbp);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ReportSubmitFormTask", localException.getMessage());
      g.RL().Ru().set(ac.a.yDM, "");
      AppMethodBeat.o(130904);
    }
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130903);
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new ip();
    ((b.a)localObject1).fsY = new iq();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
    ((b.a)localObject1).funcId = 1129;
    localObject1 = ((b.a)localObject1).ado();
    final ip localip = (ip)((b)localObject1).fsV.fta;
    localip.wuR = new LinkedList();
    ??? = new dbp();
    ((dbp)???).type = this.type;
    ((dbp)???).cwc = this.appId;
    ((dbp)???).yhT = this.hEU;
    ((dbp)???).yhU = this.pageId;
    ((dbp)???).iIF = this.cmE;
    ((dbp)???).iIG = this.bDc;
    localip.wuR.add(???);
    synchronized (getClass())
    {
      localip.wuR.addAll(aCf());
      w.a((b)localObject1, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, b paramAnonymousb, m paramAnonymousm)
        {
          AppMethodBeat.i(130901);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            synchronized (ReportSubmitFormTask.this.getClass())
            {
              ReportSubmitFormTask.y(localip.wuR);
              ab.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(130901);
              return 0;
            }
          }
          AppMethodBeat.o(130901);
          return 0;
        }
      });
      AppMethodBeat.o(130903);
      return;
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130906);
    this.type = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.hEU = paramParcel.readString();
    this.pageId = paramParcel.readString();
    this.cmE = paramParcel.readInt();
    this.bDc = paramParcel.readInt();
    AppMethodBeat.o(130906);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130905);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hEU);
    paramParcel.writeString(this.pageId);
    paramParcel.writeInt(this.cmE);
    paramParcel.writeInt(this.bDc);
    AppMethodBeat.o(130905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask
 * JD-Core Version:    0.7.0.1
 */