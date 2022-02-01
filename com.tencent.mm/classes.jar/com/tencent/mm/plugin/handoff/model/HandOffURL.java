package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.ghm;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "title", "", "url", "icon", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "nickname", "getNickname", "setNickname", "getTitle", "setTitle", "getUrl", "setUrl", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "equals", "", "other", "", "getDataType", "hashCode", "toString", "update", "newHandOff", "writeToParcel", "", "dest", "flags", "Companion", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HandOffURL
  extends HandOff
{
  public static final Parcelable.Creator<HandOffURL> CREATOR;
  public static final HandOffURL.a Companion;
  public static final String KShareUrl = "handoff#shareUrl";
  private String icon;
  private String nickname;
  private String title;
  private String url;
  
  static
  {
    AppMethodBeat.i(121743);
    Companion = new HandOffURL.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
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
    String str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.title = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.url = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.icon = str;
    paramParcel = paramParcel.readString();
    s.checkNotNull(paramParcel);
    s.s(paramParcel, "source.readString()!!");
    this.nickname = paramParcel;
    AppMethodBeat.o(121742);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, 0, null, null, null, 120, null);
    AppMethodBeat.i(266055);
    AppMethodBeat.o(266055);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, null, null, null, 112, null);
    AppMethodBeat.i(266052);
    AppMethodBeat.o(266052);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt, paramString4, null, null, 96, null);
    AppMethodBeat.i(266045);
    AppMethodBeat.o(266045);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramInt, paramString4, paramString5, null, 64, null);
    AppMethodBeat.i(266039);
    AppMethodBeat.o(266039);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    super(paramInt, paramString4, paramString5, paramString6, null, 0L, 48, null);
    AppMethodBeat.i(121740);
    this.nickname = "";
    this.title = paramString1;
    this.url = paramString2;
    this.icon = paramString3;
    AppMethodBeat.o(121740);
  }
  
  protected final String body()
  {
    AppMethodBeat.i(121736);
    String str = n.bJB("\n        <title>" + a.fP(this.title) + "</title>\n        <url>" + a.fP(this.url) + "</url>\n        <icon>" + a.fP(this.icon) + "</icon>\n    ");
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
    AppMethodBeat.i(266162);
    if (getHandOffType() == 1)
    {
      AppMethodBeat.o(266162);
      return null;
    }
    BallInfo localBallInfo = new BallInfo(2, getKey());
    localBallInfo.name = getTitle();
    localBallInfo.icon = getIcon();
    localBallInfo.fx("rawUrl", getUrl());
    AppMethodBeat.o(266162);
    return localBallInfo;
  }
  
  protected final r<drz, byte[]> doCreateMultiTaskInfo()
  {
    AppMethodBeat.i(266169);
    if (getHandOffType() == 1)
    {
      AppMethodBeat.o(266169);
      return null;
    }
    Object localObject = new drz();
    ghm localghm = new ghm();
    ((drz)localObject).title = this.title;
    ((drz)localObject).aaXP = this.icon;
    ((drz)localObject).nickname = "";
    localghm.acdA = this.url;
    localghm.idu = this.url;
    localObject = new r(localObject, localghm.toByteArray());
    AppMethodBeat.o(266169);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(266180);
    if (this == paramObject)
    {
      AppMethodBeat.o(266180);
      return true;
    }
    if (!(paramObject instanceof HandOffURL))
    {
      AppMethodBeat.o(266180);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(266180);
      return false;
    }
    if (!s.p(this.title, ((HandOffURL)paramObject).title))
    {
      AppMethodBeat.o(266180);
      return false;
    }
    if (!s.p(this.url, ((HandOffURL)paramObject).url))
    {
      AppMethodBeat.o(266180);
      return false;
    }
    if (!s.p(this.icon, ((HandOffURL)paramObject).icon))
    {
      AppMethodBeat.o(266180);
      return false;
    }
    if (!s.p(this.nickname, ((HandOffURL)paramObject).nickname))
    {
      AppMethodBeat.o(266180);
      return false;
    }
    AppMethodBeat.o(266180);
    return true;
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
  
  public final int hashCode()
  {
    AppMethodBeat.i(266185);
    int i = super.hashCode();
    int j = this.title.hashCode();
    int k = this.url.hashCode();
    int m = this.icon.hashCode();
    int n = this.nickname.hashCode();
    AppMethodBeat.o(266185);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final void setIcon(String paramString)
  {
    AppMethodBeat.i(121734);
    s.u(paramString, "<set-?>");
    this.icon = paramString;
    AppMethodBeat.o(121734);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(266107);
    s.u(paramString, "<set-?>");
    this.nickname = paramString;
    AppMethodBeat.o(266107);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(121732);
    s.u(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(121732);
  }
  
  public final void setUrl(String paramString)
  {
    AppMethodBeat.i(121733);
    s.u(paramString, "<set-?>");
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
  
  public final boolean update(HandOff paramHandOff)
  {
    AppMethodBeat.i(266122);
    s.u(paramHandOff, "newHandOff");
    boolean bool2 = super.update(paramHandOff);
    boolean bool1 = bool2;
    if ((paramHandOff instanceof HandOffURL))
    {
      bool1 = bool2;
      if (!s.p(paramHandOff, this))
      {
        if (((CharSequence)((HandOffURL)paramHandOff).title).length() <= 0) {
          break label191;
        }
        i = 1;
        if (i != 0) {
          this.title = ((HandOffURL)paramHandOff).title;
        }
        if (((CharSequence)((HandOffURL)paramHandOff).url).length() <= 0) {
          break label196;
        }
        i = 1;
        label96:
        if (i != 0) {
          this.url = ((HandOffURL)paramHandOff).url;
        }
        if (((CharSequence)((HandOffURL)paramHandOff).icon).length() <= 0) {
          break label201;
        }
        i = 1;
        label131:
        if (i != 0) {
          this.icon = ((HandOffURL)paramHandOff).icon;
        }
        if (((CharSequence)((HandOffURL)paramHandOff).nickname).length() <= 0) {
          break label206;
        }
      }
    }
    label191:
    label196:
    label201:
    label206:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.nickname = ((HandOffURL)paramHandOff).nickname;
      }
      bool1 = true;
      AppMethodBeat.o(266122);
      return bool1;
      i = 0;
      break;
      i = 0;
      break label96;
      i = 0;
      break label131;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121737);
    s.u(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(getTitle());
    paramParcel.writeString(getUrl());
    paramParcel.writeString(getIcon());
    paramParcel.writeString(getNickname());
    AppMethodBeat.o(121737);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/handoff/model/HandOffURL$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<HandOffURL>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffURL
 * JD-Core Version:    0.7.0.1
 */