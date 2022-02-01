package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.b.cj;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.au;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "", "username", "", "(Ljava/lang/String;)V", "()V", "errorMsg", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "fieldMsg", "getFieldMsg", "setFieldMsg", "isContactValid", "", "()Z", "setContactValid", "(Z)V", "isNeedShowUnFollow", "setNeedShowUnFollow", "isSyncFromDB", "setSyncFromDB", "oldIsNeedShowUnFollow", "getOldIsNeedShowUnFollow", "setOldIsNeedShowUnFollow", "old_avatar_url", "kotlin.jvm.PlatformType", "getOld_avatar_url", "setOld_avatar_url", "old_follow_flag", "", "getOld_follow_flag", "()I", "setOld_follow_flag", "(I)V", "one_time_flag", "getOne_time_flag", "setOne_time_flag", "cloneContact", "convertFrom", "", "cu", "Landroid/database/Cursor;", "convertFromTarget", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "convertTo", "Landroid/content/ContentValues;", "getAuthInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "getAvatarUrl", "getCity", "getContactId", "", "getCountry", "getCoverEntranceFlag", "getCoverUrl", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDisplayRemark", "getFeedCount", "getFollowFlag", "getFollowersCount", "getFrom", "getInteractionCount", "getLiveAlias", "getLong", "idx", "cursorColName", "matchColName", "getNickname", "getPersonalMsgUpdateTime", "getProvince", "getRawAvatarUrl", "getRawNickname", "getRetryCount", "getRewardTotalAmountInWecoin", "getSex", "getSignature", "getUpdateTime", "getUsername", "getV5UserName", "getVersion", "isBlock", "isConvertBlobToLongError", "msg", "isFollowed", "isSilence", "isValid", "setAvatarUrl", "field_avatarUrl", "setCity", "city", "setCountry", "country", "setFrom", "from", "setNickname", "field_nickname", "setProvince", "province", "setRawAvatarUrl", "rawAvatarUrl", "setRawNickname", "rawNickname", "setSex", "sex", "setSignature", "signature", "setUsername", "field_username", "setVersion", "version", "stackTraceStr", "toInfo", "toMiniInfo", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "contact", "tryParse", "cv", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends cj
  implements ch, Cloneable
{
  public static final m.a Axk;
  private static final int Axr;
  public static final int Axs;
  private static final int Axt = 0;
  private static final int Axu = 0;
  private static final Class<? extends com.tencent.mm.bx.a>[] Axv;
  private static final Map<String, Class<?>> Axw;
  private static final IAutoDBItem.MAutoDBInfo info;
  private static final int jLl;
  private static final int jMG;
  private static final int jMX;
  private static final int jSZ;
  private static final int jTs;
  private static final int jZI;
  private static final int kiD;
  private static final int koA;
  private static final int koB;
  private static final int koC;
  private static final int koD;
  private static final int koE;
  private static final int koF;
  private static final int koG;
  private static final int koH;
  private static final int koI;
  private static final int koJ;
  private static final int koK;
  private static final int koL;
  private static final int koM;
  private static final int koN;
  private static final int koO;
  private static final int koP;
  private static final int koQ;
  private static final int koR;
  private static final int koS;
  private static final int koT;
  private static final int koU;
  private static final int koV;
  private static final int koW;
  private static final int koX;
  private static final int koY;
  private static final int koZ;
  private static final int kow;
  private static final int kox;
  private static final int koy;
  private static final int koz;
  private static final int kpa;
  private static final int kpb;
  private static final int kpd;
  private static final int kpe;
  private static final int kpf;
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  public boolean Axl;
  public boolean Axm;
  int Axn;
  String Axo;
  boolean Axp;
  String Axq;
  String errorMsg;
  boolean isNeedShowUnFollow;
  int one_time_flag;
  
  static
  {
    AppMethodBeat.i(165156);
    Axk = new m.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cj.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(LocalFinderContact::class.java)");
    info = localMAutoDBInfo;
    Axr = 2;
    Axs = 1;
    username_HASHCODE = "username".hashCode();
    jTs = "nickname".hashCode();
    kow = "avatarUrl".hashCode();
    jMG = "version".hashCode();
    kox = "firstPageMD5".hashCode();
    jLl = "signature".hashCode();
    koy = "follow_Flag".hashCode();
    jZI = "pyInitial".hashCode();
    koz = "followTime".hashCode();
    koA = "coverImg".hashCode();
    koB = "spamStatus".hashCode();
    koC = "authInfo".hashCode();
    jSZ = "extInfo".hashCode();
    koD = "originalFlag".hashCode();
    koE = "originalInfo".hashCode();
    kiD = "extFlag".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    koF = "retryCount".hashCode();
    koG = "originalEntranceFlag".hashCode();
    koH = "liveCoverImg".hashCode();
    koI = "liveStatus".hashCode();
    koJ = "liveAnchorStatusFlag".hashCode();
    koK = "friendFollowCount".hashCode();
    koL = "liveSwitchFlag".hashCode();
    koM = "liveAlias".hashCode();
    koN = "rewardTotalAmountInWecoin".hashCode();
    koO = "personalMsgUpdateTime".hashCode();
    koP = "v5username".hashCode();
    koQ = "vestNickname".hashCode();
    koR = "feedCount".hashCode();
    jMX = "source".hashCode();
    koS = "liveMicSetting".hashCode();
    koT = "liveMicSettingSwitch".hashCode();
    koU = "badgeInfoList".hashCode();
    koV = "settlementInfo".hashCode();
    koW = "agencyCollaborateInfo".hashCode();
    koZ = "user_mode".hashCode();
    koX = "bindInfoList".hashCode();
    koY = "guestInfo".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
    kpa = "coverUrl".hashCode();
    kpb = "coverEntranceFlag".hashCode();
    kpd = "rawNickname".hashCode();
    kpe = "rawAvatarUrl".hashCode();
    kpf = "jumpInfoList".hashCode();
    Axv = new Class[] { bbl.class, aud.class, ei.class, fat.class, bfm.class, bry.class, avl.class, FinderAuthInfo.class, bcf.class };
    Axw = ak.e(new r[] { v.Y("authInfo", FinderAuthInfo.class), v.Y("extInfo", avl.class), v.Y("originalInfo", bry.class), v.Y("badgeInfoList", aud.class), v.Y("settlementInfo", fat.class), v.Y("agencyCollaborateInfo", ei.class), v.Y("bindInfoList", aud.class), v.Y("guestInfo", bbl.class), v.Y("jumpInfoList", bcf.class) });
    AppMethodBeat.o(165156);
  }
  
  public m()
  {
    AppMethodBeat.i(165155);
    this.Axm = true;
    this.Axn = this.field_follow_Flag;
    this.Axo = this.field_avatarUrl;
    this.Axq = "";
    this.errorMsg = "";
    AppMethodBeat.o(165155);
  }
  
  public m(String paramString)
  {
    AppMethodBeat.i(329977);
    this.Axm = true;
    this.Axn = this.field_follow_Flag;
    this.Axo = this.field_avatarUrl;
    this.Axq = "";
    this.errorMsg = "";
    this.field_username = paramString;
    AppMethodBeat.o(329977);
  }
  
  private final long a(Cursor paramCursor, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(330000);
    try
    {
      long l = paramCursor.getLong(paramInt);
      AppMethodBeat.o(330000);
      return l;
    }
    catch (Exception localException1)
    {
      if (!avb(localException1.getMessage())) {
        break label226;
      }
    }
    byte[] arrayOfByte = paramCursor.getBlob(paramInt);
    int i;
    label68:
    Class[] arrayOfClass;
    int k;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length != 0) {
        break label234;
      }
      i = 1;
      if (i != 0) {
        break label240;
      }
      i = 1;
      if (i != 0)
      {
        arrayOfClass = Axv;
        k = arrayOfClass.length;
        i = 0;
        paramCursor = null;
      }
    }
    for (;;)
    {
      com.tencent.mm.bx.a locala;
      if (i < k) {
        locala = arrayOfClass[i];
      }
      try
      {
        locala = ((com.tencent.mm.bx.a)locala.newInstance()).parseFrom(arrayOfByte);
        paramCursor = locala;
        j = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label226:
          label234:
          label240:
          int j = 0;
          continue;
          paramCursor = paramCursor.getClass();
          if (paramCursor == null)
          {
            paramCursor = "";
          }
          else
          {
            paramString1 = paramCursor.getName();
            paramCursor = paramString1;
            if (paramString1 == null) {
              paramCursor = "";
            }
          }
        }
        i += 1;
      }
      if (j != 0)
      {
        paramString2 = new StringBuilder().append(this.errorMsg).append("index=").append(paramInt).append(" cursorColName=").append(paramString1).append(" matchColName=").append(paramString2).append(" className=");
        if (paramCursor == null)
        {
          paramCursor = "";
          this.errorMsg = (paramCursor + " byteToString=" + new b(arrayOfByte) + " \n");
          AppMethodBeat.o(330000);
          return 0L;
          i = 0;
          break;
          i = 0;
          break label68;
        }
      }
    }
  }
  
  private static boolean avb(String paramString)
  {
    AppMethodBeat.i(330004);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (n.a((CharSequence)paramString, (CharSequence)"Unable to convert BLOB to long", false)); i = 0)
    {
      AppMethodBeat.o(330004);
      return true;
    }
    AppMethodBeat.o(330004);
    return false;
  }
  
  public final void Bo(String paramString)
  {
    AppMethodBeat.i(330194);
    s.u(paramString, "signature");
    this.field_signature = paramString;
    AppMethodBeat.o(330194);
  }
  
  public final void Bp(String paramString)
  {
    AppMethodBeat.i(330217);
    s.u(paramString, "province");
    avl localavl2 = this.field_extInfo;
    avl localavl1 = localavl2;
    if (localavl2 == null) {
      localavl1 = new avl();
    }
    localavl1.province = paramString;
    this.field_extInfo = localavl1;
    AppMethodBeat.o(330217);
  }
  
  public final void Bq(String paramString)
  {
    AppMethodBeat.i(330171);
    s.u(paramString, "city");
    avl localavl2 = this.field_extInfo;
    avl localavl1 = localavl2;
    if (localavl2 == null) {
      localavl1 = new avl();
    }
    localavl1.city = paramString;
    this.field_extInfo = localavl1;
    AppMethodBeat.o(330171);
  }
  
  public final String aSV()
  {
    AppMethodBeat.i(330161);
    String str = dUr();
    AppMethodBeat.o(330161);
    return str;
  }
  
  public final au ad(au paramau)
  {
    AppMethodBeat.i(330296);
    s.u(paramau, "contact");
    paramau.setNickname(dUr());
    paramau.acDG = ((CharSequence)p.b(MMApplicationContext.getContext(), (CharSequence)dUr()));
    paramau.setUsername(getUsername());
    paramau.Bo(this.field_signature);
    paramau.maN = this.systemRowid;
    paramau.pB((int)(this.field_updateTime / 1000L));
    paramau.Bq(getCity());
    paramau.pv(dUv());
    paramau.Bp(getProvince());
    AppMethodBeat.o(330296);
    return paramau;
  }
  
  public final String amx()
  {
    String str2 = this.field_avatarUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void auZ(String paramString)
  {
    AppMethodBeat.i(165150);
    s.u(paramString, "field_avatarUrl");
    this.field_avatarUrl = paramString;
    AppMethodBeat.o(165150);
  }
  
  public final void ava(String paramString)
  {
    AppMethodBeat.i(330180);
    s.u(paramString, "country");
    avl localavl2 = this.field_extInfo;
    avl localavl1 = localavl2;
    if (localavl2 == null) {
      localavl1 = new avl();
    }
    localavl1.country = paramString;
    this.field_extInfo = localavl1;
    AppMethodBeat.o(330180);
  }
  
  public final String bRT()
  {
    AppMethodBeat.i(165151);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + " head:" + this.field_avatarUrl + " converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus + ", originalFlag:" + this.field_originalFlag + ", liveAnchorFlag:" + this.field_liveAnchorStatusFlag + ", liveSwitchFlag:" + this.field_liveSwitchFlag;
    AppMethodBeat.o(165151);
    return str;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(165157);
    Object localObject = super.clone();
    AppMethodBeat.o(165157);
    return localObject;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(165147);
    label3249:
    for (;;)
    {
      int j;
      try
      {
        super.convertFrom(paramCursor);
        this.Axl = true;
        AppMethodBeat.o(165147);
        return;
      }
      catch (Exception localException)
      {
        Log.e("LocalFinderContact", s.X("convertFrom e: ", localException));
        if (!avb(localException.getMessage())) {
          continue;
        }
        s.u(localException, "e");
        String[] arrayOfString;
        Object localObject1;
        int k;
        if (paramCursor == null)
        {
          arrayOfString = null;
          if (arrayOfString == null) {
            continue;
          }
          j = arrayOfString.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject1 = arrayOfString[i];
          k = ((String)localObject1).hashCode();
          if (username_HASHCODE == k)
          {
            this.field_username = paramCursor.getString(i);
            this.Axq = (this.Axq + "field_username=" + this.field_username + ' ');
            i += 1;
            continue;
          }
        }
        else
        {
          arrayOfString = paramCursor.getColumnNames();
          continue;
        }
        if (jTs == k)
        {
          this.field_nickname = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_nickname=" + this.field_nickname + ' ');
          continue;
        }
        if (kow == k)
        {
          this.field_avatarUrl = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_avatarUrl=" + this.field_avatarUrl + ' ');
          continue;
        }
        if (jMG == k)
        {
          this.field_version = a(paramCursor, i, (String)localObject1, "version");
          this.Axq = (this.Axq + "field_version=" + this.field_version + ' ');
          continue;
        }
        if (kox == k)
        {
          this.field_firstPageMD5 = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_firstPageMD5=" + this.field_firstPageMD5 + ' ');
          continue;
        }
        if (jLl == k)
        {
          this.field_signature = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_signature=" + this.field_signature + ' ');
          continue;
        }
        if (koy == k)
        {
          this.field_follow_Flag = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_follow_Flag=" + this.field_follow_Flag + ' ');
          continue;
        }
        if (jZI == k)
        {
          this.field_pyInitial = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_pyInitial=" + this.field_pyInitial + ' ');
          continue;
        }
        if (koz == k)
        {
          this.field_followTime = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_followTime=" + this.field_followTime + ' ');
          continue;
        }
        if (koA == k)
        {
          this.field_coverImg = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_coverImg=" + this.field_coverImg + ' ');
          continue;
        }
        if (koB == k)
        {
          this.field_spamStatus = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_spamStatus=" + this.field_spamStatus + ' ');
          continue;
        }
        if (koC == k)
        {
          try
          {
            localObject1 = paramCursor.getBlob(i);
            if ((localObject1 == null) || (localObject1.length <= 0)) {
              continue;
            }
            localObject1 = new FinderAuthInfo().parseFrom((byte[])localObject1);
            if (localObject1 != null) {
              continue;
            }
            localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAuthInfo");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException1)
          {
            Log.e("LocalFinderContact", localIOException1.getMessage());
          }
          continue;
          this.field_authInfo = ((FinderAuthInfo)localIOException1);
          continue;
        }
        if (jSZ == k)
        {
          try
          {
            Object localObject2 = paramCursor.getBlob(i);
            if ((localObject2 == null) || (localObject2.length <= 0)) {
              continue;
            }
            localObject2 = new avl().parseFrom((byte[])localObject2);
            if (localObject2 != null) {
              continue;
            }
            localObject2 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderContactExtraInfo");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject2);
          }
          catch (IOException localIOException2)
          {
            Log.e("LocalFinderContact", localIOException2.getMessage());
          }
          continue;
          this.field_extInfo = ((avl)localIOException2);
          continue;
        }
        if (koD == k)
        {
          this.field_originalFlag = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_originalFlag=" + this.field_originalFlag + ' ');
          continue;
        }
        if (kpa == k)
        {
          this.field_coverUrl = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_coverUrl=" + this.field_coverUrl + ' ');
          continue;
        }
        if (kpb == k)
        {
          this.field_coverEntranceFlag = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_coverEntranceFlag=" + this.field_coverEntranceFlag + ' ');
          continue;
        }
        if (koE == k)
        {
          try
          {
            Object localObject3 = paramCursor.getBlob(i);
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              continue;
            }
            localObject3 = new bry().parseFrom((byte[])localObject3);
            if (localObject3 != null) {
              continue;
            }
            localObject3 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalInfo");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject3);
          }
          catch (IOException localIOException3)
          {
            Log.e("LocalFinderContact", localIOException3.getMessage());
          }
          continue;
          this.field_originalInfo = ((bry)localIOException3);
          continue;
        }
        if (kiD == k)
        {
          this.field_extFlag = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_extFlag=" + this.field_extFlag + ' ');
          continue;
        }
        if (updateTime_HASHCODE == k)
        {
          this.field_updateTime = a(paramCursor, i, localIOException3, "updateTime");
          this.Axq = (this.Axq + "field_updateTime=" + this.field_updateTime + ' ');
          continue;
        }
        if (koF == k)
        {
          this.field_retryCount = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_retryCount=" + this.field_retryCount + ' ');
          continue;
        }
        if (koG == k)
        {
          this.field_originalEntranceFlag = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_originalEntranceFlag=" + this.field_originalEntranceFlag + ' ');
          continue;
        }
        if (koH == k)
        {
          this.field_liveCoverImg = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_liveCoverImg=" + this.field_liveCoverImg + ' ');
          continue;
        }
        if (koI == k)
        {
          this.field_liveStatus = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_liveStatus=" + this.field_liveStatus + ' ');
          continue;
        }
        if (koJ == k)
        {
          this.field_liveAnchorStatusFlag = a(paramCursor, i, localIOException3, "liveAnchorStatusFlag");
          this.Axq = (this.Axq + "field_liveAnchorStatusFlag=" + this.field_liveAnchorStatusFlag + ' ');
          continue;
        }
        if (koK == k)
        {
          this.field_friendFollowCount = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_friendFollowCount=" + this.field_friendFollowCount + ' ');
          continue;
        }
        if (koL == k)
        {
          this.field_liveSwitchFlag = a(paramCursor, i, localIOException3, "liveSwitchFlag");
          this.Axq = (this.Axq + "field_liveSwitchFlag=" + this.field_liveSwitchFlag + ' ');
          continue;
        }
        if (koM == k)
        {
          this.field_liveAlias = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_liveAlias=" + this.field_liveAlias + ' ');
          continue;
        }
        if (koN == k)
        {
          this.field_rewardTotalAmountInWecoin = a(paramCursor, i, localIOException3, "rewardTotalAmountInWecoin");
          this.Axq = (this.Axq + "field_rewardTotalAmountInWecoin=" + this.field_rewardTotalAmountInWecoin + ' ');
          continue;
        }
        if (koO == k)
        {
          this.field_personalMsgUpdateTime = a(paramCursor, i, localIOException3, "personalMsgUpdateTime");
          this.Axq = (this.Axq + "field_personalMsgUpdateTime=" + this.field_personalMsgUpdateTime + ' ');
          continue;
        }
        if (koP == k)
        {
          this.field_v5username = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_v5username=" + this.field_v5username + ' ');
          continue;
        }
        if (koQ == k)
        {
          this.field_vestNickname = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_vestNickname=" + this.field_vestNickname + ' ');
          continue;
        }
        if (koR == k)
        {
          this.field_feedCount = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_feedCount=" + this.field_feedCount + ' ');
          continue;
        }
        if (jMX == k)
        {
          this.field_source = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_source=" + this.field_source + ' ');
          continue;
        }
        if (koS == k)
        {
          this.field_liveMicSetting = a(paramCursor, i, localIOException3, "liveMicSetting");
          this.Axq = (this.Axq + "field_liveMicSetting=" + this.field_liveMicSetting + ' ');
          continue;
        }
        if (koT == k)
        {
          this.field_liveMicSettingSwitch = a(paramCursor, i, localIOException3, "liveMicSettingSwitch");
          this.Axq = (this.Axq + "field_liveMicSettingSwitch=" + this.field_liveMicSettingSwitch + ' ');
          continue;
        }
        if (koU == k)
        {
          try
          {
            Object localObject4 = paramCursor.getBlob(i);
            if ((localObject4 == null) || (localObject4.length <= 0)) {
              continue;
            }
            localObject4 = new bfm().parseFrom((byte[])localObject4);
            if (localObject4 != null) {
              continue;
            }
            localObject4 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveBadgeInfoList");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject4);
          }
          catch (IOException localIOException4)
          {
            Log.e("LocalFinderContact", localIOException4.getMessage());
          }
          continue;
          this.field_badgeInfoList = ((bfm)localIOException4);
          continue;
        }
        if (koV == k)
        {
          try
          {
            Object localObject5 = paramCursor.getBlob(i);
            if ((localObject5 == null) || (localObject5.length <= 0)) {
              continue;
            }
            localObject5 = new fat().parseFrom((byte[])localObject5);
            if (localObject5 != null) {
              continue;
            }
            localObject5 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SettleToAgencyRelateInfo");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject5);
          }
          catch (IOException localIOException5)
          {
            Log.e("LocalFinderContact", localIOException5.getMessage());
          }
          continue;
          this.field_settlementInfo = ((fat)localIOException5);
          continue;
        }
        if (koW == k)
        {
          try
          {
            Object localObject6 = paramCursor.getBlob(i);
            if ((localObject6 == null) || (localObject6.length <= 0)) {
              continue;
            }
            localObject6 = new ei().parseFrom((byte[])localObject6);
            if (localObject6 != null) {
              continue;
            }
            localObject6 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AgencyCollaborateInfo");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject6);
          }
          catch (IOException localIOException6)
          {
            Log.e("LocalFinderContact", localIOException6.getMessage());
          }
          continue;
          this.field_agencyCollaborateInfo = ((ei)localIOException6);
          continue;
        }
        if (koZ == k)
        {
          this.field_user_mode = paramCursor.getInt(i);
          this.Axq = (this.Axq + "field_user_mode=" + this.field_feedCount + ' ');
          continue;
        }
        if (koX == k)
        {
          try
          {
            Object localObject7 = paramCursor.getBlob(i);
            if ((localObject7 == null) || (localObject7.length <= 0)) {
              continue;
            }
            localObject7 = new aud().parseFrom((byte[])localObject7);
            if (localObject7 != null) {
              continue;
            }
            localObject7 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderBindInfoList");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject7);
          }
          catch (IOException localIOException7)
          {
            Log.e("LocalFinderContact", localIOException7.getMessage());
          }
          continue;
          this.field_bindInfoList = ((aud)localIOException7);
          continue;
        }
        if (koY == k)
        {
          try
          {
            Object localObject8 = paramCursor.getBlob(i);
            if ((localObject8 == null) || (localObject8.length <= 0)) {
              continue;
            }
            localObject8 = new bbl().parseFrom((byte[])localObject8);
            if (localObject8 != null) {
              continue;
            }
            localObject8 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGuestInfo");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject8);
          }
          catch (IOException localIOException8)
          {
            Log.e("LocalFinderContact", localIOException8.getMessage());
          }
          continue;
          this.field_guestInfo = ((bbl)localIOException8);
          continue;
        }
        if (kpf == k)
        {
          try
          {
            Object localObject9 = paramCursor.getBlob(i);
            if ((localObject9 == null) || (localObject9.length <= 0)) {
              continue;
            }
            localObject9 = new bcf().parseFrom((byte[])localObject9);
            if (localObject9 != null) {
              continue;
            }
            localObject9 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderJumpInfoList");
            AppMethodBeat.o(165147);
            throw ((Throwable)localObject9);
          }
          catch (IOException localIOException9)
          {
            Log.e("LocalFinderContact", localIOException9.getMessage());
          }
          continue;
          this.field_jumpInfoList = ((bcf)localIOException9);
          continue;
        }
        if (kpd == k)
        {
          this.field_rawNickname = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_rawNickname=" + this.field_rawNickname + ' ');
          continue;
        }
        if (kpe == k)
        {
          this.field_rawAvatarUrl = paramCursor.getString(i);
          this.Axq = (this.Axq + "field_rawAvatarUrl=" + this.field_rawAvatarUrl + ' ');
          continue;
        }
        if (rowid_HASHCODE != k) {
          continue;
        }
        this.systemRowid = a(paramCursor, i, localIOException9, "rowid");
        this.Axq = (this.Axq + "systemRowid=" + this.systemRowid + ' ');
        continue;
        if (((CharSequence)this.errorMsg).length() <= 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label3249;
        }
        d.B((kotlin.g.a.a)new m.b(this, localException, j));
        break;
      }
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(330301);
    ContentValues localContentValues = super.convertTo();
    if (localContentValues.size() > 0)
    {
      s.s(localContentValues, "cv");
      d.B((kotlin.g.a.a)new m.c(localContentValues));
    }
    s.s(localContentValues, "cv");
    AppMethodBeat.o(330301);
    return localContentValues;
  }
  
  public final int dUA()
  {
    return this.field_friendFollowCount;
  }
  
  public final int dUB()
  {
    return this.field_follow_Flag;
  }
  
  public final long dUC()
  {
    return this.field_personalMsgUpdateTime;
  }
  
  public final String dUD()
  {
    String str2 = this.field_coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final m dUE()
  {
    AppMethodBeat.i(165154);
    try
    {
      m localm = (m)super.clone();
      AppMethodBeat.o(165154);
      return localm;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("LocalFinderContact", s.X("clone Contact error. e: ", localException));
        Object localObject = null;
      }
    }
  }
  
  public final String dUr()
  {
    AppMethodBeat.i(330136);
    Object localObject = (CharSequence)this.field_rawNickname;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.field_rawNickname;
      s.s(localObject, "field_rawNickname");
      AppMethodBeat.o(330136);
      return localObject;
    }
    localObject = getNickname();
    AppMethodBeat.o(330136);
    return localObject;
  }
  
  public final String dUs()
  {
    AppMethodBeat.i(330147);
    Object localObject = (CharSequence)this.field_rawAvatarUrl;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.field_rawAvatarUrl;
      s.s(localObject, "field_rawAvatarUrl");
      AppMethodBeat.o(330147);
      return localObject;
    }
    localObject = amx();
    AppMethodBeat.o(330147);
    return localObject;
  }
  
  public final long dUt()
  {
    return this.field_updateTime;
  }
  
  public final long dUu()
  {
    return this.systemRowid;
  }
  
  public final int dUv()
  {
    avl localavl = this.field_extInfo;
    if (localavl == null) {
      return 0;
    }
    return localavl.sex;
  }
  
  public final String dUw()
  {
    AppMethodBeat.i(165152);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + "  converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus;
    AppMethodBeat.o(165152);
    return str;
  }
  
  public final long dUx()
  {
    return this.field_rewardTotalAmountInWecoin;
  }
  
  public final long dUy()
  {
    return this.field_interactionCount;
  }
  
  public final int dUz()
  {
    return this.field_feedCount;
  }
  
  public final String getCity()
  {
    Object localObject = this.field_extInfo;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((avl)localObject).city;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final String getCountry()
  {
    AppMethodBeat.i(330185);
    avl localavl = this.field_extInfo;
    Object localObject = localavl;
    if (localavl == null) {
      localObject = new avl();
    }
    localObject = ((avl)localObject).country;
    if (localObject == null)
    {
      AppMethodBeat.o(330185);
      return "";
    }
    AppMethodBeat.o(330185);
    return localObject;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getNickname()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getProvince()
  {
    Object localObject = this.field_extInfo;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((avl)localObject).province;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final int getRetryCount()
  {
    return this.field_retryCount;
  }
  
  public final String getSignature()
  {
    String str2 = this.field_signature;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getUsername()
  {
    String str2 = this.field_username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final boolean isBlock()
  {
    return this.field_spamStatus == 1;
  }
  
  public final boolean isValid()
  {
    return this.Axm;
  }
  
  public final void pv(int paramInt)
  {
    AppMethodBeat.i(330230);
    avl localavl2 = this.field_extInfo;
    avl localavl1 = localavl2;
    if (localavl2 == null) {
      localavl1 = new avl();
    }
    localavl1.sex = paramInt;
    this.field_extInfo = localavl1;
    AppMethodBeat.o(330230);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(165149);
    s.u(paramString, "field_nickname");
    this.field_nickname = paramString;
    AppMethodBeat.o(165149);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(165148);
    s.u(paramString, "field_username");
    this.field_username = paramString;
    AppMethodBeat.o(165148);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(165153);
    String str = bRT();
    AppMethodBeat.o(165153);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.m
 * JD-Core Version:    0.7.0.1
 */