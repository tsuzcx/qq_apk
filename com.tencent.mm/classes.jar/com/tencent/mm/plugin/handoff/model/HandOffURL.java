package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.fah;
import java.util.Collection;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.m;
import kotlin.n.n;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "title", "", "url", "icon", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "memberProperties", "", "Lkotlin/reflect/KProperty1;", "getMemberProperties", "()Ljava/util/Collection;", "memberProperties$delegate", "Lkotlin/Lazy;", "nickname", "getNickname", "setNickname", "getTitle", "setTitle", "getUrl", "setUrl", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "getDataType", "toString", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
@Keep
public final class HandOffURL
  extends HandOff
{
  public static final Parcelable.Creator<HandOffURL> CREATOR;
  public static final HandOffURL.a Companion;
  public static final String KShareUrl = "handoff#shareUrl";
  private String icon;
  private final f memberProperties$delegate;
  private String nickname;
  private String title;
  private String url;
  
  static
  {
    AppMethodBeat.i(121743);
    Companion = new HandOffURL.a((byte)0);
    CREATOR = (Parcelable.Creator)new HandOffURL.b();
    AppMethodBeat.o(121743);
  }
  
  public HandOffURL()
  {
    this("", "", "", 0, null, null, null, 120, null);
  }
  
  public HandOffURL(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121742);
    this.nickname = "";
    this.memberProperties$delegate = g.ah((kotlin.g.a.a)HandOffURL.c.yhJ);
    String str = paramParcel.readString();
    if (str == null) {
      p.hyc();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      p.hyc();
    }
    this.url = str;
    str = paramParcel.readString();
    if (str == null) {
      p.hyc();
    }
    this.icon = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      p.hyc();
    }
    this.nickname = paramParcel;
    AppMethodBeat.o(121742);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, 0, null, null, null, 120, null);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, null, null, null, 112, null);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt, paramString4, null, null, 96, null);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramInt, paramString4, paramString5, null, 64, null);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    super(paramInt, paramString4, paramString5, paramString6, null, 0L, 48, null);
    AppMethodBeat.i(121740);
    this.nickname = "";
    this.memberProperties$delegate = g.ah((kotlin.g.a.a)HandOffURL.c.yhJ);
    this.title = paramString1;
    this.url = paramString2;
    this.icon = paramString3;
    AppMethodBeat.o(121740);
  }
  
  private final Collection<m<HandOffURL, ?>> getMemberProperties()
  {
    AppMethodBeat.i(238063);
    Collection localCollection = (Collection)this.memberProperties$delegate.getValue();
    AppMethodBeat.o(238063);
    return localCollection;
  }
  
  protected final String body()
  {
    AppMethodBeat.i(121736);
    String str = n.buv("\n        <title>" + a.du(this.title) + "</title>\n        <url>" + a.du(this.url) + "</url>\n        <icon>" + a.du(this.icon) + "</icon>\n    ");
    AppMethodBeat.o(121736);
    return str;
  }
  
  public final HandOff copy()
  {
    AppMethodBeat.i(121738);
    Object localObject = new HandOffURL(this.title, this.url, this.icon, getHandOffType(), getFrom(), getTo(), getKey());
    ((HandOffURL)localObject).setId(getId());
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121738);
    return localObject;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final BallInfo doCreateBallInfo()
  {
    AppMethodBeat.i(238064);
    if (getHandOffType() == 1)
    {
      AppMethodBeat.o(238064);
      return null;
    }
    BallInfo localBallInfo = new BallInfo(2, getKey());
    localBallInfo.name = this.title;
    localBallInfo.icon = this.icon;
    localBallInfo.eS("rawUrl", this.url);
    AppMethodBeat.o(238064);
    return localBallInfo;
  }
  
  protected final o<cru, byte[]> doCreateMultiTaskInfo()
  {
    AppMethodBeat.i(238065);
    if (getHandOffType() == 1)
    {
      AppMethodBeat.o(238065);
      return null;
    }
    Object localObject = new cru();
    fah localfah = new fah();
    ((cru)localObject).title = this.title;
    ((cru)localObject).MwR = this.icon;
    ((cru)localObject).nickname = "";
    localfah.Nwh = this.url;
    localfah.edo = this.url;
    localObject = new o(localObject, localfah.toByteArray());
    AppMethodBeat.o(238065);
    return localObject;
  }
  
  public final int getDataType()
  {
    return 2;
  }
  
  public final String getIcon()
  {
    return this.icon;
  }
  
  public final String getNickname()
  {
    return this.nickname;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
  
  public final void setIcon(String paramString)
  {
    AppMethodBeat.i(121734);
    p.h(paramString, "<set-?>");
    this.icon = paramString;
    AppMethodBeat.o(121734);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(238062);
    p.h(paramString, "<set-?>");
    this.nickname = paramString;
    AppMethodBeat.o(238062);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(121732);
    p.h(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(121732);
  }
  
  public final void setUrl(String paramString)
  {
    AppMethodBeat.i(121733);
    p.h(paramString, "<set-?>");
    this.url = paramString;
    AppMethodBeat.o(121733);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121739);
    String str = "HandOffURL(key='" + getKey() + "', id='" + getId() + "', createTime='" + getCreateTime() + ", title='" + this.title + "', url='" + this.url + "', icon='" + this.icon + "')";
    AppMethodBeat.o(121739);
    return str;
  }
  
  public final void update(HandOff paramHandOff)
  {
    AppMethodBeat.i(121735);
    p.h(paramHandOff, "newHandOff");
    super.update(paramHandOff);
    if ((paramHandOff instanceof HandOffURL))
    {
      if (((CharSequence)((HandOffURL)paramHandOff).title).length() <= 0) {
        break label172;
      }
      i = 1;
      if (i != 0) {
        this.title = ((HandOffURL)paramHandOff).title;
      }
      if (((CharSequence)((HandOffURL)paramHandOff).url).length() <= 0) {
        break label177;
      }
      i = 1;
      label80:
      if (i != 0) {
        this.url = ((HandOffURL)paramHandOff).url;
      }
      if (((CharSequence)((HandOffURL)paramHandOff).icon).length() <= 0) {
        break label182;
      }
      i = 1;
      label115:
      if (i != 0) {
        this.icon = ((HandOffURL)paramHandOff).icon;
      }
      if (((CharSequence)((HandOffURL)paramHandOff).nickname).length() <= 0) {
        break label187;
      }
    }
    label172:
    label177:
    label182:
    label187:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.nickname = ((HandOffURL)paramHandOff).nickname;
      }
      AppMethodBeat.o(121735);
      return;
      i = 0;
      break;
      i = 0;
      break label80;
      i = 0;
      break label115;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121737);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(121737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffURL
 * JD-Core Version:    0.7.0.1
 */