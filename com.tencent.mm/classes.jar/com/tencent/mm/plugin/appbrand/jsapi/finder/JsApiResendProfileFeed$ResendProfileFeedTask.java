package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.plugin.finder.upload.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

class JsApiResendProfileFeed$ResendProfileFeedTask
  extends MainProcessTask
  implements l
{
  public static final Parcelable.Creator<ResendProfileFeedTask> CREATOR;
  private String dln;
  private q kNl;
  private String kNo;
  private long kNy;
  private int kje;
  
  static
  {
    AppMethodBeat.i(163986);
    CREATOR = new JsApiResendProfileFeed.ResendProfileFeedTask.1();
    AppMethodBeat.o(163986);
  }
  
  public JsApiResendProfileFeed$ResendProfileFeedTask(Parcel paramParcel)
  {
    AppMethodBeat.i(163977);
    e(paramParcel);
    AppMethodBeat.o(163977);
  }
  
  public JsApiResendProfileFeed$ResendProfileFeedTask(q paramq, int paramInt, long paramLong)
  {
    this.kNl = paramq;
    this.kje = paramInt;
    this.kNy = paramLong;
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(163981);
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163976);
        Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().wP(JsApiResendProfileFeed.ResendProfileFeedTask.a(JsApiResendProfileFeed.ResendProfileFeedTask.this));
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
          g.a locala = com.tencent.mm.plugin.finder.upload.g.sJk;
          com.tencent.mm.plugin.finder.upload.g.cKK().k((FinderItem)localObject);
          localObject = com.tencent.mm.plugin.finder.upload.g.sJk;
          com.tencent.mm.plugin.finder.upload.g.cKK().a(JsApiResendProfileFeed.ResendProfileFeedTask.this);
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
  
  public final void aOB()
  {
    AppMethodBeat.i(163980);
    ad.i("MicroMsg.Finder.JsApiResendProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.kNl.getAppId(), this.kNo, Integer.valueOf(this.kje), Boolean.valueOf(this.kNl.isRunning()) });
    if ((!bt.isNullOrNil(this.dln)) && (this.dln.equals("onPostEnd")))
    {
      new JsApiResendProfileFeed.a((byte)0).g(this.kNl).Ph(this.kNo).bir();
      bhO();
      AppMethodBeat.o(163980);
      return;
    }
    this.kNl.h(this.kje, this.kNo);
    AppMethodBeat.o(163980);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(163978);
    this.kNy = paramParcel.readLong();
    this.dln = paramParcel.readString();
    this.kNo = paramParcel.readString();
    AppMethodBeat.o(163978);
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(163982);
    Object localObject;
    if (paramLong == this.kNy)
    {
      localObject = com.tencent.mm.plugin.finder.upload.g.sJk;
      com.tencent.mm.plugin.finder.upload.g.cKK().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong));
      this.dln = "onPostEnd";
      if (paramBoolean)
      {
        this.kNo = a.a("", 0, (JSONObject)localObject);
        bhX();
        AppMethodBeat.o(163982);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Finder.JsApiResendProfileFeed", localException, "PostFinderTask onPostEnd", new Object[0]);
        continue;
        this.kNo = a.a("post fail", -1, (JSONObject)localObject);
      }
    }
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean) {}
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163983);
    Object localObject;
    if (paramLong1 == this.kNy)
    {
      localObject = com.tencent.mm.plugin.finder.upload.g.sJk;
      com.tencent.mm.plugin.finder.upload.g.cKK().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong1));
      this.dln = "onPostEnd";
      this.kNo = a.a("", 0, (JSONObject)localObject);
      bhX();
      AppMethodBeat.o(163983);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Finder.JsApiResendProfileFeed", localException, "PostFinderTask onPostEnd", new Object[0]);
      }
    }
  }
  
  public void onPostStart(long paramLong) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(163979);
    paramParcel.writeLong(this.kNy);
    paramParcel.writeString(this.dln);
    paramParcel.writeString(this.kNo);
    AppMethodBeat.o(163979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiResendProfileFeed.ResendProfileFeedTask
 * JD-Core Version:    0.7.0.1
 */