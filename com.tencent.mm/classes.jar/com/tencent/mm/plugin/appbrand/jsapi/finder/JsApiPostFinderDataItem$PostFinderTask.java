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
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private String content;
  private String dcx;
  private q jRd;
  private String jRg;
  private String jRm;
  private long jRn;
  private int joH;
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
    this.jRd = paramq;
    this.joH = paramInt1;
    this.mediaType = paramInt2;
    this.jRm = paramString1;
    this.content = paramString2;
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(163968);
    ad.i("MicroMsg.Finder.JsApiPostFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.jRd.getAppId(), this.jRg, Integer.valueOf(this.joH), Boolean.valueOf(this.jRd.isRunning()) });
    if ((!bt.isNullOrNil(this.dcx)) && (this.dcx.equals("onPostEnd")))
    {
      new a((byte)0).g(this.jRd).HJ(this.jRg).aXQ();
      aXn();
      AppMethodBeat.o(163968);
      return;
    }
    this.jRd.h(this.joH, this.jRg);
    AppMethodBeat.o(163968);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(163969);
    try
    {
      JSONArray localJSONArray = new JSONArray(this.jRm);
      final ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add((FinderJsApiMediaObj)a.a(localJSONArray.optJSONObject(i), FinderJsApiMediaObj.class));
        i += 1;
      }
      com.tencent.e.h.Iye.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163963);
          bmc localbmc = new bmc();
          Object localObject2 = localArrayList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (FinderJsApiMediaObj)((Iterator)localObject2).next();
            com.tencent.mm.plugin.finder.upload.h localh;
            if (((FinderJsApiMediaObj)localObject1).mediaType == 4) {
              localh = com.tencent.mm.plugin.finder.upload.h.qRq;
            }
            for (localObject1 = com.tencent.mm.plugin.finder.upload.h.a(((FinderJsApiMediaObj)localObject1).mediaPath, ((FinderJsApiMediaObj)localObject1).thumbInfo.thumbPath, null, "");; localObject1 = com.tencent.mm.plugin.finder.upload.h.mQ(((FinderJsApiMediaObj)localObject1).mediaPath, ((FinderJsApiMediaObj)localObject1).thumbInfo.thumbPath))
            {
              localbmc.mediaList.add(localObject1);
              break;
              localh = com.tencent.mm.plugin.finder.upload.h.qRq;
            }
          }
          Object localObject1 = JsApiPostFinderDataItem.PostFinderTask.this;
          localObject2 = f.qRf;
          JsApiPostFinderDataItem.PostFinderTask.a((JsApiPostFinderDataItem.PostFinderTask)localObject1, f.crB().a(JsApiPostFinderDataItem.PostFinderTask.a(JsApiPostFinderDataItem.PostFinderTask.this), JsApiPostFinderDataItem.PostFinderTask.b(JsApiPostFinderDataItem.PostFinderTask.this), localbmc, null, null, 0, null, false, "", null));
          if (JsApiPostFinderDataItem.PostFinderTask.c(JsApiPostFinderDataItem.PostFinderTask.this) != -1L)
          {
            localObject1 = f.qRf;
            f.crB().a(JsApiPostFinderDataItem.PostFinderTask.this);
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
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(163966);
    this.mediaType = paramParcel.readInt();
    this.jRm = paramParcel.readString();
    this.content = paramParcel.readString();
    this.jRg = paramParcel.readString();
    this.dcx = paramParcel.readString();
    AppMethodBeat.o(163966);
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(163970);
    Object localObject;
    if (paramLong == this.jRn)
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
        AppMethodBeat.o(163970);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Finder.JsApiPostFinderDataItem", localException, "PostFinderTask onPostEnd", new Object[0]);
        continue;
        this.jRg = a.a("post fail", -1, (JSONObject)localObject);
      }
    }
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean) {}
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163971);
    Object localObject;
    if (paramLong1 == this.jRn)
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
      AppMethodBeat.o(163971);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Finder.JsApiPostFinderDataItem", localException, "PostFinderTask onPostEnd", new Object[0]);
      }
    }
  }
  
  public void onPostStart(long paramLong) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(163967);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeString(this.jRm);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.jRg);
    paramParcel.writeString(this.dcx);
    AppMethodBeat.o(163967);
  }
  
  static final class a
    extends p
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onFeedPostCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiPostFinderDataItem.PostFinderTask
 * JD-Core Version:    0.7.0.1
 */