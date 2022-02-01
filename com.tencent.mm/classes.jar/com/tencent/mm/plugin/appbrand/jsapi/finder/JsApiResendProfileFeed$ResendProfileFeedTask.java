package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.upload.f.a;
import com.tencent.mm.plugin.finder.upload.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

class JsApiResendProfileFeed$ResendProfileFeedTask
  extends MainProcessTask
  implements k
{
  public static final Parcelable.Creator<ResendProfileFeedTask> CREATOR;
  private String dcx;
  private q jRd;
  private String jRg;
  private long jRq;
  private int joH;
  
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
    this.jRd = paramq;
    this.joH = paramInt;
    this.jRq = paramLong;
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(163980);
    ad.i("MicroMsg.Finder.JsApiResendProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.jRd.getAppId(), this.jRg, Integer.valueOf(this.joH), Boolean.valueOf(this.jRd.isRunning()) });
    if ((!bt.isNullOrNil(this.dcx)) && (this.dcx.equals("onPostEnd")))
    {
      new JsApiResendProfileFeed.a((byte)0).g(this.jRd).HJ(this.jRg).aXQ();
      aXn();
      AppMethodBeat.o(163980);
      return;
    }
    this.jRd.h(this.joH, this.jRg);
    AppMethodBeat.o(163980);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(163981);
    h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163976);
        Object localObject = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().qy(JsApiResendProfileFeed.ResendProfileFeedTask.a(JsApiResendProfileFeed.ResendProfileFeedTask.this));
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
          f.a locala = f.qRf;
          f.crB().i((FinderItem)localObject);
          localObject = f.qRf;
          f.crB().a(JsApiResendProfileFeed.ResendProfileFeedTask.this);
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
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(163978);
    this.jRq = paramParcel.readLong();
    this.dcx = paramParcel.readString();
    this.jRg = paramParcel.readString();
    AppMethodBeat.o(163978);
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(163982);
    Object localObject;
    if (paramLong == this.jRq)
    {
      localObject = f.qRf;
      f.crB().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong));
      this.dcx = "onPostEnd";
      if (paramBoolean)
      {
        this.jRg = a.a("", 0, (JSONObject)localObject);
        aXw();
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
        this.jRg = a.a("post fail", -1, (JSONObject)localObject);
      }
    }
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean) {}
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163983);
    Object localObject;
    if (paramLong1 == this.jRq)
    {
      localObject = f.qRf;
      f.crB().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong1));
      this.dcx = "onPostEnd";
      this.jRg = a.a("", 0, (JSONObject)localObject);
      aXw();
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
    paramParcel.writeLong(this.jRq);
    paramParcel.writeString(this.dcx);
    paramParcel.writeString(this.jRg);
    AppMethodBeat.o(163979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiResendProfileFeed.ResendProfileFeedTask
 * JD-Core Version:    0.7.0.1
 */