package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.l;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

class JsApiResendProfileFeed$ResendProfileFeedTask
  extends MainProcessTask
  implements q
{
  public static final Parcelable.Creator<ResendProfileFeedTask> CREATOR;
  private String event;
  private com.tencent.mm.plugin.appbrand.s lVM;
  private String lVP;
  private long lVZ;
  private int lqe;
  
  static
  {
    AppMethodBeat.i(163986);
    CREATOR = new JsApiResendProfileFeed.ResendProfileFeedTask.1();
    AppMethodBeat.o(163986);
  }
  
  public JsApiResendProfileFeed$ResendProfileFeedTask(Parcel paramParcel)
  {
    AppMethodBeat.i(163977);
    f(paramParcel);
    AppMethodBeat.o(163977);
  }
  
  public JsApiResendProfileFeed$ResendProfileFeedTask(com.tencent.mm.plugin.appbrand.s params, int paramInt, long paramLong)
  {
    this.lVM = params;
    this.lqe = paramInt;
    this.lVZ = paramLong;
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(163981);
    h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163976);
        Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fz(JsApiResendProfileFeed.ResendProfileFeedTask.a(JsApiResendProfileFeed.ResendProfileFeedTask.this));
        JSONObject localJSONObject = new JSONObject();
        if (((FinderItem)localObject).field_localFlag == 0) {}
        try
        {
          localJSONObject.put("feedLocalId", JsApiResendProfileFeed.ResendProfileFeedTask.a(JsApiResendProfileFeed.ResendProfileFeedTask.this));
          label56:
          JsApiResendProfileFeed.ResendProfileFeedTask.a(JsApiResendProfileFeed.ResendProfileFeedTask.this, a.a("", 1, localJSONObject));
          JsApiResendProfileFeed.ResendProfileFeedTask.b(JsApiResendProfileFeed.ResendProfileFeedTask.this);
          AppMethodBeat.o(163976);
          return;
          g.a locala = com.tencent.mm.plugin.finder.upload.g.vSJ;
          com.tencent.mm.plugin.finder.upload.g.dBa().t((FinderItem)localObject);
          localObject = com.tencent.mm.plugin.finder.upload.g.vSJ;
          com.tencent.mm.plugin.finder.upload.g.dBa().a(JsApiResendProfileFeed.ResendProfileFeedTask.this);
          JsApiResendProfileFeed.ResendProfileFeedTask.a(JsApiResendProfileFeed.ResendProfileFeedTask.this, a.a("", 0, localJSONObject));
          JsApiResendProfileFeed.ResendProfileFeedTask.c(JsApiResendProfileFeed.ResendProfileFeedTask.this);
          AppMethodBeat.o(163976);
          return;
        }
        catch (Exception localException)
        {
          break label56;
        }
      }
    }, "JsApiResendProfileFeed");
    AppMethodBeat.o(163981);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(163980);
    Log.i("MicroMsg.Finder.JsApiResendProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.lVM.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.lVM.isRunning()) });
    if ((!Util.isNullOrNil(this.event)) && (this.event.equals("onPostEnd")))
    {
      new JsApiResendProfileFeed.a((byte)0).g(this.lVM).Zg(this.lVP).bEo();
      bDK();
      AppMethodBeat.o(163980);
      return;
    }
    this.lVM.i(this.lqe, this.lVP);
    AppMethodBeat.o(163980);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(163978);
    this.lVZ = paramParcel.readLong();
    this.event = paramParcel.readString();
    this.lVP = paramParcel.readString();
    AppMethodBeat.o(163978);
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(163982);
    Object localObject;
    if (paramLong == this.lVZ)
    {
      localObject = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.dBa().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong));
      this.event = "onPostEnd";
      if (paramBoolean)
      {
        this.lVP = a.a("", 0, (JSONObject)localObject);
        bDU();
        AppMethodBeat.o(163982);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Finder.JsApiResendProfileFeed", localException, "PostFinderTask onPostEnd", new Object[0]);
        continue;
        this.lVP = a.a("post fail", -1, (JSONObject)localObject);
      }
    }
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean) {}
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163983);
    Object localObject;
    if (paramLong1 == this.lVZ)
    {
      localObject = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.dBa().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong1));
      this.event = "onPostEnd";
      this.lVP = a.a("", 0, (JSONObject)localObject);
      bDU();
      AppMethodBeat.o(163983);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Finder.JsApiResendProfileFeed", localException, "PostFinderTask onPostEnd", new Object[0]);
      }
    }
  }
  
  public void onPostStart(long paramLong) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(163979);
    paramParcel.writeLong(this.lVZ);
    paramParcel.writeString(this.event);
    paramParcel.writeString(this.lVP);
    AppMethodBeat.o(163979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiResendProfileFeed.ResendProfileFeedTask
 * JD-Core Version:    0.7.0.1
 */