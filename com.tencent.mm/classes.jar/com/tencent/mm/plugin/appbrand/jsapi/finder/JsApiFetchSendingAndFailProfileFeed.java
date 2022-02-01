package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiFetchSendingAndFailProfileFeed
  extends c<y>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "fetchSendingAndFailProfileFeed";
  
  static class FetchSendingAndFailProfileFeedTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<FetchSendingAndFailProfileFeedTask> CREATOR;
    private y qqV;
    private String rYq;
    private int ror;
    
    static
    {
      AppMethodBeat.i(163937);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163937);
    }
    
    public FetchSendingAndFailProfileFeedTask(int paramInt, y paramy)
    {
      this.ror = paramInt;
      this.qqV = paramy;
    }
    
    public FetchSendingAndFailProfileFeedTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163931);
      h(paramParcel);
      AppMethodBeat.o(163931);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(163934);
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163930);
          Object localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFeedStorage().eZj();
          JSONArray localJSONArray = new JSONArray();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
            FinderObject localFinderObject = localFinderItem.getFinderObject();
            try
            {
              JSONObject localJSONObject = new JSONObject();
              a.a(localFinderObject, localJSONObject);
              localJSONObject.put("status", localFinderItem.field_localFlag);
              localJSONObject.put("feedLocalId", String.valueOf(localFinderItem.systemRowid));
              localJSONArray.put(localJSONObject);
            }
            catch (Exception localException) {}
          }
          JsApiFetchSendingAndFailProfileFeed.FetchSendingAndFailProfileFeedTask.a(JsApiFetchSendingAndFailProfileFeed.FetchSendingAndFailProfileFeedTask.this, a.a("", 0, localJSONArray));
          JsApiFetchSendingAndFailProfileFeed.FetchSendingAndFailProfileFeedTask.a(JsApiFetchSendingAndFailProfileFeed.FetchSendingAndFailProfileFeedTask.this);
          AppMethodBeat.o(163930);
        }
      }, "JsApiFetchSendingAndFailProfileFeed");
      AppMethodBeat.o(163934);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(163935);
      try
      {
        localJSONObject1 = new JSONObject(this.rYq);
        localJSONArray = localJSONObject1.optJSONArray("data");
        if (localJSONArray == null) {
          break label269;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          JSONObject localJSONObject1;
          JSONArray localJSONArray;
          int i;
          Object localObject1;
          int j;
          JSONObject localJSONObject2;
          Object localObject2;
          String str;
          k localk;
          label269:
          this.rYq = a.a(localException.getMessage(), -1, new JSONArray());
          continue;
          j += 1;
          continue;
          i += 1;
        }
      }
      if (i < localJSONArray.length())
      {
        localObject1 = localJSONArray.optJSONObject(i);
        if (localObject1 == null) {
          break label383;
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("objectDesc");
        if (localObject1 == null) {
          break label383;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("media");
        if (localObject1 == null) {
          break label383;
        }
        j = 0;
        if (j >= ((JSONArray)localObject1).length()) {
          break label383;
        }
        localJSONObject2 = ((JSONArray)localObject1).optJSONObject(j);
        if (localJSONObject2 != null)
        {
          localObject2 = localJSONObject2.optString("url");
          str = localJSONObject2.optString("thumbUrl");
          if ((!Util.isNullOrNil((String)localObject2)) && (!((String)localObject2).startsWith("http")))
          {
            localk = new k();
            if (this.qqV.getFileSystem().a(new u((String)localObject2), null, false, localk) == r.qML) {
              localJSONObject2.put("url", localk.value);
            }
          }
          if ((!Util.isNullOrNil(str)) && (!str.startsWith("http")))
          {
            localObject2 = new k();
            if (this.qqV.getFileSystem().a(new u(str), null, false, (k)localObject2) == r.qML) {
              localJSONObject2.put("thumbUrl", ((k)localObject2).value);
            }
          }
        }
      }
      else
      {
        this.rYq = localJSONObject1.toString();
        Log.i("MicroMsg.Finder.JsApiFetchSendingAndFailProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.qqV.getAppId(), this.rYq, Integer.valueOf(this.ror), Boolean.valueOf(this.qqV.isRunning()) });
        this.qqV.callback(this.ror, this.rYq);
        cpx();
        AppMethodBeat.o(163935);
        return;
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(163932);
      this.rYq = paramParcel.readString();
      AppMethodBeat.o(163932);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163933);
      paramParcel.writeString(this.rYq);
      AppMethodBeat.o(163933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiFetchSendingAndFailProfileFeed
 * JD-Core Version:    0.7.0.1
 */