package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.l;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiFetchSendingAndFailProfileFeed
  extends d<s>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "fetchSendingAndFailProfileFeed";
  
  static class FetchSendingAndFailProfileFeedTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<FetchSendingAndFailProfileFeedTask> CREATOR;
    private s kGT;
    private String lVP;
    private int lqe;
    
    static
    {
      AppMethodBeat.i(163937);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163937);
    }
    
    public FetchSendingAndFailProfileFeedTask(int paramInt, s params)
    {
      this.lqe = paramInt;
      this.kGT = params;
    }
    
    public FetchSendingAndFailProfileFeedTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163931);
      f(paramParcel);
      AppMethodBeat.o(163931);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(163934);
      h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163930);
          Object localObject = ((PluginFinder)g.ah(PluginFinder.class)).getFeedStorage().dxD();
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
    
    public final void bjk()
    {
      AppMethodBeat.i(163935);
      try
      {
        localJSONObject1 = new JSONObject(this.lVP);
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
          com.tencent.mm.plugin.appbrand.ac.i locali;
          label269:
          this.lVP = a.a(localException.getMessage(), -1, new JSONArray());
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
            locali = new com.tencent.mm.plugin.appbrand.ac.i();
            if (this.kGT.getFileSystem().a(new o((String)localObject2), null, false, locali) == m.kSu) {
              localJSONObject2.put("url", locali.value);
            }
          }
          if ((!Util.isNullOrNil(str)) && (!str.startsWith("http")))
          {
            localObject2 = new com.tencent.mm.plugin.appbrand.ac.i();
            if (this.kGT.getFileSystem().a(new o(str), null, false, (com.tencent.mm.plugin.appbrand.ac.i)localObject2) == m.kSu) {
              localJSONObject2.put("thumbUrl", ((com.tencent.mm.plugin.appbrand.ac.i)localObject2).value);
            }
          }
        }
      }
      else
      {
        this.lVP = localJSONObject1.toString();
        Log.i("MicroMsg.Finder.JsApiFetchSendingAndFailProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.kGT.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.kGT.isRunning()) });
        this.kGT.i(this.lqe, this.lVP);
        bDK();
        AppMethodBeat.o(163935);
        return;
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(163932);
      this.lVP = paramParcel.readString();
      AppMethodBeat.o(163932);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163933);
      paramParcel.writeString(this.lVP);
      AppMethodBeat.o(163933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiFetchSendingAndFailProfileFeed
 * JD-Core Version:    0.7.0.1
 */