package SummaryCard;

import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespSummaryCard
  extends JceStruct
{
  static int cache_eAddOption;
  static AlbumInfo cache_oLatestPhotos;
  static DateCard cache_stDateCard;
  static VipBaseInfo cache_stDiamonds;
  static QCallInfo cache_stQCallInfo;
  static VipBaseInfo cache_stVipInfo;
  static VoiceInfo cache_stVoiceInfo;
  static ArrayList cache_vAddQuestion;
  static byte[] cache_vRespLastGameInfo;
  static byte[] cache_vRespStarInfo;
  static byte[] cache_vRespTemplateInfo;
  static byte[] cache_vRichSign;
  static byte[] cache_vSeed;
  static ArrayList cache_vvRespServices;
  public byte bAge = 0;
  public byte bSex = 0;
  public byte bValid4Vote = 0;
  public int eAddOption = 101;
  public int iBirthday = 0;
  public int iFace = 0;
  public int iLastestVoteCount = 0;
  public int iLevel = 0;
  public int iPhotoCount = 0;
  public int iVoteCount = 0;
  public long lCacheControl = 0L;
  public long lUIN = 0L;
  public long lUserFlag = 0L;
  public AlbumInfo oLatestPhotos = null;
  public DateCard stDateCard = null;
  public VipBaseInfo stDiamonds = null;
  public QCallInfo stQCallInfo = null;
  public VipBaseInfo stVipInfo = null;
  public VoiceInfo stVoiceInfo = null;
  public String strAutoRemark = "";
  public String strCity = "";
  public String strContactName = "";
  public String strCountry = "";
  public String strDiscussName = "";
  public String strGroupName = "";
  public String strGroupNick = "";
  public String strLoginDesc = "";
  public String strMobile = "";
  public String strNick = "";
  public String strProvince = "";
  public String strQzoneFeedsDesc = "";
  public String strRemark = "";
  public String strRespMusicInfo = "";
  public String strShowName = "";
  public String strSign = "";
  public String strSpaceName = "";
  public String strStatus = "";
  public long uAccelerateMultiple = 0L;
  public long uLoginDays = 0L;
  public long uQQMasterLoginDays = 20L;
  public long uSignModifyTime = 0L;
  public long uTemplateId = 0L;
  public long ulFaceAddonId = 0L;
  public long ulShowControl = 0L;
  public ArrayList vAddQuestion = null;
  public byte[] vRespLastGameInfo = null;
  public byte[] vRespStarInfo = null;
  public byte[] vRespTemplateInfo = null;
  public byte[] vRichSign = null;
  public byte[] vSeed = null;
  public ArrayList vvRespServices = null;
  
  public RespSummaryCard() {}
  
  public RespSummaryCard(int paramInt1, byte paramByte1, byte paramByte2, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, long paramLong1, String paramString10, AlbumInfo paramAlbumInfo, int paramInt3, int paramInt4, byte paramByte3, String paramString11, String paramString12, String paramString13, long paramLong2, long paramLong3, int paramInt5, int paramInt6, ArrayList paramArrayList1, byte[] paramArrayOfByte1, String paramString14, VipBaseInfo paramVipBaseInfo1, String paramString15, VoiceInfo paramVoiceInfo, byte[] paramArrayOfByte2, long paramLong4, byte[] paramArrayOfByte3, long paramLong5, long paramLong6, String paramString16, long paramLong7, long paramLong8, long paramLong9, byte[] paramArrayOfByte4, String paramString17, byte[] paramArrayOfByte5, VipBaseInfo paramVipBaseInfo2, long paramLong10, ArrayList paramArrayList2, String paramString18, DateCard paramDateCard, int paramInt7, QCallInfo paramQCallInfo)
  {
    this.iFace = paramInt1;
    this.bSex = paramByte1;
    this.bAge = paramByte2;
    this.strNick = paramString1;
    this.strRemark = paramString2;
    this.iLevel = paramInt2;
    this.strProvince = paramString3;
    this.strCity = paramString4;
    this.strSign = paramString5;
    this.strGroupName = paramString6;
    this.strGroupNick = paramString7;
    this.strMobile = paramString8;
    this.strContactName = paramString9;
    this.ulShowControl = paramLong1;
    this.strQzoneFeedsDesc = paramString10;
    this.oLatestPhotos = paramAlbumInfo;
    this.iVoteCount = paramInt3;
    this.iLastestVoteCount = paramInt4;
    this.bValid4Vote = paramByte3;
    this.strCountry = paramString11;
    this.strStatus = paramString12;
    this.strAutoRemark = paramString13;
    this.lCacheControl = paramLong2;
    this.lUIN = paramLong3;
    this.iPhotoCount = paramInt5;
    this.eAddOption = paramInt6;
    this.vAddQuestion = paramArrayList1;
    this.vSeed = paramArrayOfByte1;
    this.strDiscussName = paramString14;
    this.stVipInfo = paramVipBaseInfo1;
    this.strShowName = paramString15;
    this.stVoiceInfo = paramVoiceInfo;
    this.vRichSign = paramArrayOfByte2;
    this.uSignModifyTime = paramLong4;
    this.vRespLastGameInfo = paramArrayOfByte3;
    this.lUserFlag = paramLong5;
    this.uLoginDays = paramLong6;
    this.strLoginDesc = paramString16;
    this.uTemplateId = paramLong7;
    this.uQQMasterLoginDays = paramLong8;
    this.ulFaceAddonId = paramLong9;
    this.vRespTemplateInfo = paramArrayOfByte4;
    this.strRespMusicInfo = paramString17;
    this.vRespStarInfo = paramArrayOfByte5;
    this.stDiamonds = paramVipBaseInfo2;
    this.uAccelerateMultiple = paramLong10;
    this.vvRespServices = paramArrayList2;
    this.strSpaceName = paramString18;
    this.stDateCard = paramDateCard;
    this.iBirthday = paramInt7;
    this.stQCallInfo = paramQCallInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFace = paramJceInputStream.read(this.iFace, 0, false);
    this.bSex = paramJceInputStream.read(this.bSex, 1, false);
    this.bAge = paramJceInputStream.read(this.bAge, 2, false);
    this.strNick = paramJceInputStream.readString(3, false);
    this.strRemark = paramJceInputStream.readString(4, false);
    this.iLevel = paramJceInputStream.read(this.iLevel, 5, false);
    this.strProvince = paramJceInputStream.readString(6, false);
    this.strCity = paramJceInputStream.readString(7, false);
    this.strSign = paramJceInputStream.readString(8, false);
    this.strGroupName = paramJceInputStream.readString(9, false);
    this.strGroupNick = paramJceInputStream.readString(10, false);
    this.strMobile = paramJceInputStream.readString(11, false);
    this.strContactName = paramJceInputStream.readString(12, false);
    this.ulShowControl = paramJceInputStream.read(this.ulShowControl, 13, false);
    this.strQzoneFeedsDesc = paramJceInputStream.readString(14, false);
    if (cache_oLatestPhotos == null) {
      cache_oLatestPhotos = new AlbumInfo();
    }
    this.oLatestPhotos = ((AlbumInfo)paramJceInputStream.read(cache_oLatestPhotos, 15, false));
    this.iVoteCount = paramJceInputStream.read(this.iVoteCount, 16, false);
    this.iLastestVoteCount = paramJceInputStream.read(this.iLastestVoteCount, 17, false);
    this.bValid4Vote = paramJceInputStream.read(this.bValid4Vote, 18, false);
    this.strCountry = paramJceInputStream.readString(19, false);
    this.strStatus = paramJceInputStream.readString(20, false);
    this.strAutoRemark = paramJceInputStream.readString(21, false);
    this.lCacheControl = paramJceInputStream.read(this.lCacheControl, 22, false);
    this.lUIN = paramJceInputStream.read(this.lUIN, 23, false);
    this.iPhotoCount = paramJceInputStream.read(this.iPhotoCount, 24, false);
    this.eAddOption = paramJceInputStream.read(this.eAddOption, 25, false);
    if (cache_vAddQuestion == null)
    {
      cache_vAddQuestion = new ArrayList();
      cache_vAddQuestion.add("");
    }
    this.vAddQuestion = ((ArrayList)paramJceInputStream.read(cache_vAddQuestion, 26, false));
    if (cache_vSeed == null)
    {
      cache_vSeed = (byte[])new byte[1];
      ((byte[])cache_vSeed)[0] = 0;
    }
    this.vSeed = ((byte[])paramJceInputStream.read(cache_vSeed, 27, false));
    this.strDiscussName = paramJceInputStream.readString(28, false);
    if (cache_stVipInfo == null) {
      cache_stVipInfo = new VipBaseInfo();
    }
    this.stVipInfo = ((VipBaseInfo)paramJceInputStream.read(cache_stVipInfo, 29, false));
    this.strShowName = paramJceInputStream.readString(30, false);
    if (cache_stVoiceInfo == null) {
      cache_stVoiceInfo = new VoiceInfo();
    }
    this.stVoiceInfo = ((VoiceInfo)paramJceInputStream.read(cache_stVoiceInfo, 31, false));
    if (cache_vRichSign == null)
    {
      cache_vRichSign = (byte[])new byte[1];
      ((byte[])cache_vRichSign)[0] = 0;
    }
    this.vRichSign = ((byte[])paramJceInputStream.read(cache_vRichSign, 32, false));
    this.uSignModifyTime = paramJceInputStream.read(this.uSignModifyTime, 33, false);
    if (cache_vRespLastGameInfo == null)
    {
      cache_vRespLastGameInfo = (byte[])new byte[1];
      ((byte[])cache_vRespLastGameInfo)[0] = 0;
    }
    this.vRespLastGameInfo = ((byte[])paramJceInputStream.read(cache_vRespLastGameInfo, 34, false));
    this.lUserFlag = paramJceInputStream.read(this.lUserFlag, 35, false);
    this.uLoginDays = paramJceInputStream.read(this.uLoginDays, 36, false);
    this.strLoginDesc = paramJceInputStream.readString(37, false);
    this.uTemplateId = paramJceInputStream.read(this.uTemplateId, 38, false);
    this.uQQMasterLoginDays = paramJceInputStream.read(this.uQQMasterLoginDays, 39, false);
    this.ulFaceAddonId = paramJceInputStream.read(this.ulFaceAddonId, 40, false);
    if (cache_vRespTemplateInfo == null)
    {
      cache_vRespTemplateInfo = (byte[])new byte[1];
      ((byte[])cache_vRespTemplateInfo)[0] = 0;
    }
    this.vRespTemplateInfo = ((byte[])paramJceInputStream.read(cache_vRespTemplateInfo, 41, false));
    this.strRespMusicInfo = paramJceInputStream.readString(42, false);
    if (cache_vRespStarInfo == null)
    {
      cache_vRespStarInfo = (byte[])new byte[1];
      ((byte[])cache_vRespStarInfo)[0] = 0;
    }
    this.vRespStarInfo = ((byte[])paramJceInputStream.read(cache_vRespStarInfo, 43, false));
    if (cache_stDiamonds == null) {
      cache_stDiamonds = new VipBaseInfo();
    }
    this.stDiamonds = ((VipBaseInfo)paramJceInputStream.read(cache_stDiamonds, 44, false));
    this.uAccelerateMultiple = paramJceInputStream.read(this.uAccelerateMultiple, 45, false);
    if (cache_vvRespServices == null)
    {
      cache_vvRespServices = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_vvRespServices.add(arrayOfByte);
    }
    this.vvRespServices = ((ArrayList)paramJceInputStream.read(cache_vvRespServices, 46, false));
    this.strSpaceName = paramJceInputStream.readString(47, false);
    if (cache_stDateCard == null) {
      cache_stDateCard = new DateCard();
    }
    this.stDateCard = ((DateCard)paramJceInputStream.read(cache_stDateCard, 48, false));
    this.iBirthday = paramJceInputStream.read(this.iBirthday, 49, false);
    if (cache_stQCallInfo == null) {
      cache_stQCallInfo = new QCallInfo();
    }
    this.stQCallInfo = ((QCallInfo)paramJceInputStream.read(cache_stQCallInfo, 50, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFace, 0);
    paramJceOutputStream.write(this.bSex, 1);
    paramJceOutputStream.write(this.bAge, 2);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 3);
    }
    if (this.strRemark != null) {
      paramJceOutputStream.write(this.strRemark, 4);
    }
    paramJceOutputStream.write(this.iLevel, 5);
    if (this.strProvince != null) {
      paramJceOutputStream.write(this.strProvince, 6);
    }
    if (this.strCity != null) {
      paramJceOutputStream.write(this.strCity, 7);
    }
    if (this.strSign != null) {
      paramJceOutputStream.write(this.strSign, 8);
    }
    if (this.strGroupName != null) {
      paramJceOutputStream.write(this.strGroupName, 9);
    }
    if (this.strGroupNick != null) {
      paramJceOutputStream.write(this.strGroupNick, 10);
    }
    if (this.strMobile != null) {
      paramJceOutputStream.write(this.strMobile, 11);
    }
    if (this.strContactName != null) {
      paramJceOutputStream.write(this.strContactName, 12);
    }
    paramJceOutputStream.write(this.ulShowControl, 13);
    if (this.strQzoneFeedsDesc != null) {
      paramJceOutputStream.write(this.strQzoneFeedsDesc, 14);
    }
    if (this.oLatestPhotos != null) {
      paramJceOutputStream.write(this.oLatestPhotos, 15);
    }
    paramJceOutputStream.write(this.iVoteCount, 16);
    paramJceOutputStream.write(this.iLastestVoteCount, 17);
    paramJceOutputStream.write(this.bValid4Vote, 18);
    if (this.strCountry != null) {
      paramJceOutputStream.write(this.strCountry, 19);
    }
    if (this.strStatus != null) {
      paramJceOutputStream.write(this.strStatus, 20);
    }
    if (this.strAutoRemark != null) {
      paramJceOutputStream.write(this.strAutoRemark, 21);
    }
    paramJceOutputStream.write(this.lCacheControl, 22);
    paramJceOutputStream.write(this.lUIN, 23);
    paramJceOutputStream.write(this.iPhotoCount, 24);
    paramJceOutputStream.write(this.eAddOption, 25);
    if (this.vAddQuestion != null) {
      paramJceOutputStream.write(this.vAddQuestion, 26);
    }
    if (this.vSeed != null) {
      paramJceOutputStream.write(this.vSeed, 27);
    }
    if (this.strDiscussName != null) {
      paramJceOutputStream.write(this.strDiscussName, 28);
    }
    if (this.stVipInfo != null) {
      paramJceOutputStream.write(this.stVipInfo, 29);
    }
    if (this.strShowName != null) {
      paramJceOutputStream.write(this.strShowName, 30);
    }
    if (this.stVoiceInfo != null) {
      paramJceOutputStream.write(this.stVoiceInfo, 31);
    }
    if (this.vRichSign != null) {
      paramJceOutputStream.write(this.vRichSign, 32);
    }
    paramJceOutputStream.write(this.uSignModifyTime, 33);
    if (this.vRespLastGameInfo != null) {
      paramJceOutputStream.write(this.vRespLastGameInfo, 34);
    }
    paramJceOutputStream.write(this.lUserFlag, 35);
    paramJceOutputStream.write(this.uLoginDays, 36);
    if (this.strLoginDesc != null) {
      paramJceOutputStream.write(this.strLoginDesc, 37);
    }
    paramJceOutputStream.write(this.uTemplateId, 38);
    paramJceOutputStream.write(this.uQQMasterLoginDays, 39);
    paramJceOutputStream.write(this.ulFaceAddonId, 40);
    if (this.vRespTemplateInfo != null) {
      paramJceOutputStream.write(this.vRespTemplateInfo, 41);
    }
    if (this.strRespMusicInfo != null) {
      paramJceOutputStream.write(this.strRespMusicInfo, 42);
    }
    if (this.vRespStarInfo != null) {
      paramJceOutputStream.write(this.vRespStarInfo, 43);
    }
    if (this.stDiamonds != null) {
      paramJceOutputStream.write(this.stDiamonds, 44);
    }
    paramJceOutputStream.write(this.uAccelerateMultiple, 45);
    if (this.vvRespServices != null) {
      paramJceOutputStream.write(this.vvRespServices, 46);
    }
    if (this.strSpaceName != null) {
      paramJceOutputStream.write(this.strSpaceName, 47);
    }
    if (this.stDateCard != null) {
      paramJceOutputStream.write(this.stDateCard, 48);
    }
    paramJceOutputStream.write(this.iBirthday, 49);
    if (this.stQCallInfo != null) {
      paramJceOutputStream.write(this.stQCallInfo, 50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCard.RespSummaryCard
 * JD-Core Version:    0.7.0.1
 */