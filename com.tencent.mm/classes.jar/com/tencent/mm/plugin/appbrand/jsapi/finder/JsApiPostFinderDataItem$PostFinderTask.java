package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.upload.k;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class JsApiPostFinderDataItem$PostFinderTask
  extends MainProcessTask
  implements k
{
  public static final Parcelable.Creator<PostFinderTask> CREATOR;
  private String cZV;
  private String content;
  private int jOT;
  private q krP;
  private String krS;
  private String krY;
  private long krZ;
  private int mediaType;
  
  static
  {
    AppMethodBeat.i(163973);
    CREATOR = new JsApiPostFinderDataItem.PostFinderTask.2();
    AppMethodBeat.o(163973);
  }
  
  private JsApiPostFinderDataItem$PostFinderTask(Parcel paramParcel)
  {
    AppMethodBeat.i(163965);
    e(paramParcel);
    AppMethodBeat.o(163965);
  }
  
  public JsApiPostFinderDataItem$PostFinderTask(q paramq, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.krP = paramq;
    this.jOT = paramInt1;
    this.mediaType = paramInt2;
    this.krY = paramString1;
    this.content = paramString2;
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(163969);
    try
    {
      JSONArray localJSONArray = new JSONArray(this.krY);
      final ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add((FinderJsApiMediaObj)a.a(localJSONArray.optJSONObject(i), FinderJsApiMediaObj.class));
        i += 1;
      }
      com.tencent.e.h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163963);
          bqr localbqr = new bqr();
          Object localObject2 = localArrayList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (FinderJsApiMediaObj)((Iterator)localObject2).next();
            com.tencent.mm.plugin.finder.upload.h localh;
            if (((FinderJsApiMediaObj)localObject1).mediaType == 4) {
              localh = com.tencent.mm.plugin.finder.upload.h.rNr;
            }
            for (localObject1 = com.tencent.mm.plugin.finder.upload.h.a(((FinderJsApiMediaObj)localObject1).mediaPath, ((FinderJsApiMediaObj)localObject1).thumbInfo.thumbPath, null, "");; localObject1 = com.tencent.mm.plugin.finder.upload.h.gi(((FinderJsApiMediaObj)localObject1).mediaPath, ((FinderJsApiMediaObj)localObject1).thumbInfo.thumbPath))
            {
              localbqr.mediaList.add(localObject1);
              break;
              localh = com.tencent.mm.plugin.finder.upload.h.rNr;
            }
          }
          Object localObject1 = JsApiPostFinderDataItem.PostFinderTask.this;
          localObject2 = f.rNg;
          JsApiPostFinderDataItem.PostFinderTask.a((JsApiPostFinderDataItem.PostFinderTask)localObject1, f.cCv().a(JsApiPostFinderDataItem.PostFinderTask.a(JsApiPostFinderDataItem.PostFinderTask.this), JsApiPostFinderDataItem.PostFinderTask.b(JsApiPostFinderDataItem.PostFinderTask.this), localbqr, null, null, 0, null, false, "", null));
          if (JsApiPostFinderDataItem.PostFinderTask.c(JsApiPostFinderDataItem.PostFinderTask.this) != -1L)
          {
            localObject1 = f.rNg;
            f.cCv().a(JsApiPostFinderDataItem.PostFinderTask.this);
            localObject1 = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject1).put("feedLocalId", JsApiPostFinderDataItem.PostFinderTask.c(JsApiPostFinderDataItem.PostFinderTask.this));
            label201:
            JsApiPostFinderDataItem.PostFinderTask.a(JsApiPostFinderDataItem.PostFinderTask.this, a.a("", 0, (JSONObject)localObject1));
            for (;;)
            {
              JsApiPostFinderDataItem.PostFinderTask.d(JsApiPostFinderDataItem.PostFinderTask.this);
              AppMethodBeat.o(163963);
              return;
              JsApiPostFinderDataItem.PostFinderTask.a(JsApiPostFinderDataItem.PostFinderTask.this, a.a("not found contact", -1, new JSONObject()));
            }
          }
          catch (Exception localException)
          {
            break label201;
          }
        }
      }, "JsApiPostFinderDataItem");
      AppMethodBeat.o(163969);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(163969);
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(163968);
    ac.i("MicroMsg.Finder.JsApiPostFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.krP.getAppId(), this.krS, Integer.valueOf(this.jOT), Boolean.valueOf(this.krP.isRunning()) });
    if ((!bs.isNullOrNil(this.cZV)) && (this.cZV.equals("onPostEnd")))
    {
      new a((byte)0).g(this.krP).LN(this.krS).beN();
      bek();
      AppMethodBeat.o(163968);
      return;
    }
    this.krP.h(this.jOT, this.krS);
    AppMethodBeat.o(163968);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(163966);
    this.mediaType = paramParcel.readInt();
    this.krY = paramParcel.readString();
    this.content = paramParcel.readString();
    this.krS = paramParcel.readString();
    this.cZV = paramParcel.readString();
    AppMethodBeat.o(163966);
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(163970);
    Object localObject;
    if (paramLong == this.krZ)
    {
      localObject = f.rNg;
      f.cCv().b(this);
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
        AppMethodBeat.o(163970);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Finder.JsApiPostFinderDataItem", localException, "PostFinderTask onPostEnd", new Object[0]);
        continue;
        this.krS = a.a("post fail", -1, (JSONObject)localObject);
      }
    }
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean) {}
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163971);
    Object localObject;
    if (paramLong1 == this.krZ)
    {
      localObject = f.rNg;
      f.cCv().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong1));
      this.cZV = "onPostEnd";
      this.krS = a.a("", 0, (JSONObject)localObject);
      bet();
      AppMethodBeat.o(163971);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Finder.JsApiPostFinderDataItem", localException, "PostFinderTask onPostEnd", new Object[0]);
      }
    }
  }
  
  public void onPostStart(long paramLong) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(163967);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeString(this.krY);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.krS);
    paramParcel.writeString(this.cZV);
    AppMethodBeat.o(163967);
  }
  
  static final class a
    extends p
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onFeedPostCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiPostFinderDataItem.PostFinderTask
 * JD-Core Version:    0.7.0.1
 */