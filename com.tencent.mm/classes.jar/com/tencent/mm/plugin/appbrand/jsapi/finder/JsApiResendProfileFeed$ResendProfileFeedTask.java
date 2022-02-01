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
import com.tencent.mm.plugin.finder.upload.f.a;
import com.tencent.mm.plugin.finder.upload.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

class JsApiResendProfileFeed$ResendProfileFeedTask
  extends MainProcessTask
  implements k
{
  public static final Parcelable.Creator<ResendProfileFeedTask> CREATOR;
  private String cZV;
  private int jOT;
  private q krP;
  private String krS;
  private long ksc;
  
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
    this.krP = paramq;
    this.jOT = paramInt;
    this.ksc = paramLong;
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(163981);
    h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163976);
        Object localObject = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().uO(JsApiResendProfileFeed.ResendProfileFeedTask.a(JsApiResendProfileFeed.ResendProfileFeedTask.this));
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
          f.a locala = com.tencent.mm.plugin.finder.upload.f.rNg;
          com.tencent.mm.plugin.finder.upload.f.cCv().j((FinderItem)localObject);
          localObject = com.tencent.mm.plugin.finder.upload.f.rNg;
          com.tencent.mm.plugin.finder.upload.f.cCv().a(JsApiResendProfileFeed.ResendProfileFeedTask.this);
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
  
  public final void aLr()
  {
    AppMethodBeat.i(163980);
    ac.i("MicroMsg.Finder.JsApiResendProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.krP.getAppId(), this.krS, Integer.valueOf(this.jOT), Boolean.valueOf(this.krP.isRunning()) });
    if ((!bs.isNullOrNil(this.cZV)) && (this.cZV.equals("onPostEnd")))
    {
      new JsApiResendProfileFeed.a((byte)0).g(this.krP).LN(this.krS).beN();
      bek();
      AppMethodBeat.o(163980);
      return;
    }
    this.krP.h(this.jOT, this.krS);
    AppMethodBeat.o(163980);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(163978);
    this.ksc = paramParcel.readLong();
    this.cZV = paramParcel.readString();
    this.krS = paramParcel.readString();
    AppMethodBeat.o(163978);
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(163982);
    Object localObject;
    if (paramLong == this.ksc)
    {
      localObject = com.tencent.mm.plugin.finder.upload.f.rNg;
      com.tencent.mm.plugin.finder.upload.f.cCv().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong));
      this.cZV = "onPostEnd";
      if (paramBoolean)
      {
        this.krS = a.a("", 0, (JSONObject)localObject);
        bet();
        AppMethodBeat.o(163982);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Finder.JsApiResendProfileFeed", localException, "PostFinderTask onPostEnd", new Object[0]);
        continue;
        this.krS = a.a("post fail", -1, (JSONObject)localObject);
      }
    }
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean) {}
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163983);
    Object localObject;
    if (paramLong1 == this.ksc)
    {
      localObject = com.tencent.mm.plugin.finder.upload.f.rNg;
      com.tencent.mm.plugin.finder.upload.f.cCv().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong1));
      this.cZV = "onPostEnd";
      this.krS = a.a("", 0, (JSONObject)localObject);
      bet();
      AppMethodBeat.o(163983);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Finder.JsApiResendProfileFeed", localException, "PostFinderTask onPostEnd", new Object[0]);
      }
    }
  }
  
  public void onPostStart(long paramLong) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(163979);
    paramParcel.writeLong(this.ksc);
    paramParcel.writeString(this.cZV);
    paramParcel.writeString(this.krS);
    AppMethodBeat.o(163979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiResendProfileFeed.ResendProfileFeedTask
 * JD-Core Version:    0.7.0.1
 */