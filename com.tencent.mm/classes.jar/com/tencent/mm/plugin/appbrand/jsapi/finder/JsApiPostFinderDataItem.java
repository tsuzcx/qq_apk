package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.p;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiPostFinderDataItem
  extends c<v>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "postFinderDataItem";
  
  static class PostFinderTask
    extends MainProcessTask
    implements q
  {
    public static final Parcelable.Creator<PostFinderTask> CREATOR;
    private String content;
    private String event;
    private int mediaType;
    private v oSU;
    private String oSX;
    private String oTd;
    private long oTe;
    private int okO;
    
    static
    {
      AppMethodBeat.i(163973);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163973);
    }
    
    private PostFinderTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163965);
      f(paramParcel);
      AppMethodBeat.o(163965);
    }
    
    public PostFinderTask(v paramv, int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.oSU = paramv;
      this.okO = paramInt1;
      this.mediaType = paramInt2;
      this.oTd = paramString1;
      this.content = paramString2;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(163969);
      try
      {
        JSONArray localJSONArray = new JSONArray(this.oTd);
        final ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add((FinderJsApiMediaObj)a.a(localJSONArray.optJSONObject(i), FinderJsApiMediaObj.class));
          i += 1;
        }
        h.ZvG.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163963);
            csf localcsf = new csf();
            Object localObject2 = localArrayList.iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (FinderJsApiMediaObj)((Iterator)localObject2).next();
              com.tencent.mm.plugin.finder.upload.i locali;
              if (((FinderJsApiMediaObj)localObject1).mediaType == 4) {
                locali = com.tencent.mm.plugin.finder.upload.i.AAy;
              }
              for (localObject1 = com.tencent.mm.plugin.finder.upload.i.a(((FinderJsApiMediaObj)localObject1).mediaPath, ((FinderJsApiMediaObj)localObject1).thumbInfo.thumbPath, null, "");; localObject1 = com.tencent.mm.plugin.finder.upload.i.hp(((FinderJsApiMediaObj)localObject1).mediaPath, ((FinderJsApiMediaObj)localObject1).thumbInfo.thumbPath))
              {
                localcsf.mediaList.add(localObject1);
                break;
                locali = com.tencent.mm.plugin.finder.upload.i.AAy;
              }
            }
            Object localObject1 = JsApiPostFinderDataItem.PostFinderTask.this;
            localObject2 = g.AAk;
            JsApiPostFinderDataItem.PostFinderTask.a((JsApiPostFinderDataItem.PostFinderTask)localObject1, g.ecj().a(new p(JsApiPostFinderDataItem.PostFinderTask.a(JsApiPostFinderDataItem.PostFinderTask.this), JsApiPostFinderDataItem.PostFinderTask.b(JsApiPostFinderDataItem.PostFinderTask.this), localcsf, null, null, 0, null, false, "", null, false, false, null, "", "", 0, null)));
            if (JsApiPostFinderDataItem.PostFinderTask.c(JsApiPostFinderDataItem.PostFinderTask.this) != -1L)
            {
              localObject1 = g.AAk;
              g.ecj().a(JsApiPostFinderDataItem.PostFinderTask.this);
              localObject1 = new JSONObject();
            }
            try
            {
              ((JSONObject)localObject1).put("feedLocalId", JsApiPostFinderDataItem.PostFinderTask.c(JsApiPostFinderDataItem.PostFinderTask.this));
              label217:
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
              break label217;
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
    
    public final void bsK()
    {
      AppMethodBeat.i(163968);
      Log.i("MicroMsg.Finder.JsApiPostFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.oSU.getAppId(), this.oSX, Integer.valueOf(this.okO), Boolean.valueOf(this.oSU.isRunning()) });
      if ((!Util.isNullOrNil(this.event)) && (this.event.equals("onPostEnd")))
      {
        new a((byte)0).i(this.oSU).agT(this.oSX).bPO();
        bPk();
        AppMethodBeat.o(163968);
        return;
      }
      this.oSU.j(this.okO, this.oSX);
      AppMethodBeat.o(163968);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(163966);
      this.mediaType = paramParcel.readInt();
      this.oTd = paramParcel.readString();
      this.content = paramParcel.readString();
      this.oSX = paramParcel.readString();
      this.event = paramParcel.readString();
      AppMethodBeat.o(163966);
    }
    
    public void onPostEnd(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(163970);
      Object localObject;
      if (paramLong == this.oTe)
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
          AppMethodBeat.o(163970);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Finder.JsApiPostFinderDataItem", localException, "PostFinderTask onPostEnd", new Object[0]);
          continue;
          this.oSX = a.a("post fail", -1, (JSONObject)localObject);
        }
      }
    }
    
    public void onPostNotify(long paramLong, boolean paramBoolean) {}
    
    public void onPostOk(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163971);
      Object localObject;
      if (paramLong1 == this.oTe)
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
        AppMethodBeat.o(163971);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Finder.JsApiPostFinderDataItem", localException, "PostFinderTask onPostEnd", new Object[0]);
        }
      }
    }
    
    public void onPostStart(long paramLong) {}
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163967);
      paramParcel.writeInt(this.mediaType);
      paramParcel.writeString(this.oTd);
      paramParcel.writeString(this.content);
      paramParcel.writeString(this.oSX);
      paramParcel.writeString(this.event);
      AppMethodBeat.o(163967);
    }
    
    static final class a
      extends r
    {
      private static final int CTRL_INDEX = -2;
      private static final String NAME = "onFeedPostCallback";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiPostFinderDataItem
 * JD-Core Version:    0.7.0.1
 */