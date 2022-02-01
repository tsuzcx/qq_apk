package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.l;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo;
import com.tencent.mm.protocal.protobuf.bve;
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
  implements l
{
  public static final Parcelable.Creator<PostFinderTask> CREATOR;
  private String content;
  private String dln;
  private q kNl;
  private String kNo;
  private String kNu;
  private long kNv;
  private int kje;
  private int mediaType;
  
  static
  {
    AppMethodBeat.i(163973);
    CREATOR = new Parcelable.Creator() {};
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
    this.kNl = paramq;
    this.kje = paramInt1;
    this.mediaType = paramInt2;
    this.kNu = paramString1;
    this.content = paramString2;
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(163969);
    try
    {
      JSONArray localJSONArray = new JSONArray(this.kNu);
      final ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add((FinderJsApiMediaObj)a.a(localJSONArray.optJSONObject(i), FinderJsApiMediaObj.class));
        i += 1;
      }
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163963);
          bve localbve = new bve();
          Object localObject2 = localArrayList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (FinderJsApiMediaObj)((Iterator)localObject2).next();
            com.tencent.mm.plugin.finder.upload.i locali;
            if (((FinderJsApiMediaObj)localObject1).mediaType == 4) {
              locali = com.tencent.mm.plugin.finder.upload.i.sJt;
            }
            for (localObject1 = com.tencent.mm.plugin.finder.upload.i.a(((FinderJsApiMediaObj)localObject1).mediaPath, ((FinderJsApiMediaObj)localObject1).thumbInfo.thumbPath, null, "");; localObject1 = com.tencent.mm.plugin.finder.upload.i.gt(((FinderJsApiMediaObj)localObject1).mediaPath, ((FinderJsApiMediaObj)localObject1).thumbInfo.thumbPath))
            {
              localbve.mediaList.add(localObject1);
              break;
              locali = com.tencent.mm.plugin.finder.upload.i.sJt;
            }
          }
          Object localObject1 = JsApiPostFinderDataItem.PostFinderTask.this;
          localObject2 = g.sJk;
          JsApiPostFinderDataItem.PostFinderTask.a((JsApiPostFinderDataItem.PostFinderTask)localObject1, g.cKK().a(JsApiPostFinderDataItem.PostFinderTask.a(JsApiPostFinderDataItem.PostFinderTask.this), JsApiPostFinderDataItem.PostFinderTask.b(JsApiPostFinderDataItem.PostFinderTask.this), localbve, null, null, 0, null, false, "", null));
          if (JsApiPostFinderDataItem.PostFinderTask.c(JsApiPostFinderDataItem.PostFinderTask.this) != -1L)
          {
            localObject1 = g.sJk;
            g.cKK().a(JsApiPostFinderDataItem.PostFinderTask.this);
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
  
  public final void aOB()
  {
    AppMethodBeat.i(163968);
    ad.i("MicroMsg.Finder.JsApiPostFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.kNl.getAppId(), this.kNo, Integer.valueOf(this.kje), Boolean.valueOf(this.kNl.isRunning()) });
    if ((!bt.isNullOrNil(this.dln)) && (this.dln.equals("onPostEnd")))
    {
      new a((byte)0).g(this.kNl).Ph(this.kNo).bir();
      bhO();
      AppMethodBeat.o(163968);
      return;
    }
    this.kNl.h(this.kje, this.kNo);
    AppMethodBeat.o(163968);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(163966);
    this.mediaType = paramParcel.readInt();
    this.kNu = paramParcel.readString();
    this.content = paramParcel.readString();
    this.kNo = paramParcel.readString();
    this.dln = paramParcel.readString();
    AppMethodBeat.o(163966);
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(163970);
    Object localObject;
    if (paramLong == this.kNv)
    {
      localObject = g.sJk;
      g.cKK().b(this);
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
        this.kNo = a.a("post fail", -1, (JSONObject)localObject);
      }
    }
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean) {}
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(163971);
    Object localObject;
    if (paramLong1 == this.kNv)
    {
      localObject = g.sJk;
      g.cKK().b(this);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("feedLocalId", String.valueOf(paramLong1));
      this.dln = "onPostEnd";
      this.kNo = a.a("", 0, (JSONObject)localObject);
      bhX();
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
    paramParcel.writeString(this.kNu);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.kNo);
    paramParcel.writeString(this.dln);
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