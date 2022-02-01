package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResendProfileFeed
  extends c<v>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "resendProfileFeed";
  
  static class ResendProfileFeedTask
    extends MainProcessTask
    implements q
  {
    public static final Parcelable.Creator<ResendProfileFeedTask> CREATOR;
    private String event;
    private v oSU;
    private String oSX;
    private long oTh;
    private int okO;
    
    static
    {
      AppMethodBeat.i(163986);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163986);
    }
    
    public ResendProfileFeedTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163977);
      f(paramParcel);
      AppMethodBeat.o(163977);
    }
    
    public ResendProfileFeedTask(v paramv, int paramInt, long paramLong)
    {
      this.oSU = paramv;
      this.okO = paramInt;
      this.oTh = paramLong;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(163981);
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163976);
          Object localObject = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage().MI(JsApiResendProfileFeed.ResendProfileFeedTask.a(JsApiResendProfileFeed.ResendProfileFeedTask.this));
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
            g.a locala = g.AAk;
            g.ecj().v((FinderItem)localObject);
            localObject = g.AAk;
            g.ecj().a(JsApiResendProfileFeed.ResendProfileFeedTask.this);
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
    
    public final void bsK()
    {
      AppMethodBeat.i(163980);
      Log.i("MicroMsg.Finder.JsApiResendProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.oSU.getAppId(), this.oSX, Integer.valueOf(this.okO), Boolean.valueOf(this.oSU.isRunning()) });
      if ((!Util.isNullOrNil(this.event)) && (this.event.equals("onPostEnd")))
      {
        new JsApiResendProfileFeed.a((byte)0).i(this.oSU).agT(this.oSX).bPO();
        bPk();
        AppMethodBeat.o(163980);
        return;
      }
      this.oSU.j(this.okO, this.oSX);
      AppMethodBeat.o(163980);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(163978);
      this.oTh = paramParcel.readLong();
      this.event = paramParcel.readString();
      this.oSX = paramParcel.readString();
      AppMethodBeat.o(163978);
    }
    
    public void onPostEnd(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(163982);
      Object localObject;
      if (paramLong == this.oTh)
      {
        localObject = g.AAk;
        g.ecj().b(this);
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong));
        this.event = "onPostEnd";
        if (paramBoolean)
        {
          this.oSX = a.a("", 0, (JSONObject)localObject);
          bPt();
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
          this.oSX = a.a("post fail", -1, (JSONObject)localObject);
        }
      }
    }
    
    public void onPostNotify(long paramLong, boolean paramBoolean) {}
    
    public void onPostOk(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163983);
      Object localObject;
      if (paramLong1 == this.oTh)
      {
        localObject = g.AAk;
        g.ecj().b(this);
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong1));
        this.event = "onPostEnd";
        this.oSX = a.a("", 0, (JSONObject)localObject);
        bPt();
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
      paramParcel.writeLong(this.oTh);
      paramParcel.writeString(this.event);
      paramParcel.writeString(this.oSX);
      AppMethodBeat.o(163979);
    }
  }
  
  static final class a
    extends r
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onFeedPostCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiResendProfileFeed
 * JD-Core Version:    0.7.0.1
 */