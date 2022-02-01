package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import appoint.define.appoint_define.AddressInfo;
import appoint.define.appoint_define.AppointContent;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LocaleInfo;
import appoint.define.appoint_define.PublisherInfo;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import appoint.define.appoint_define.TravelInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7cd.AppointBrife;
import tencent.im.oidb.cmd0x7ce.AppintDetail;
import tencent.im.oidb.cmd0x7de.UserProfile;

public class DatingUtil
{
  public static final int a = 86400000;
  public static final int b = 3600000;
  public static final int c = 0;
  public static final int d = 4;
  public static final int e = 3001;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2130838482;
    }
    return 2130838480;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramInt1 = 3;
    }
    do
    {
      return paramInt1;
      if (paramInt1 > 0) {
        return 1;
      }
      paramInt1 = i;
    } while (paramInt2 <= 0);
    return 2;
  }
  
  public static Drawable a(String paramString, QQAppInterface paramQQAppInterface, FaceDecoder paramFaceDecoder, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramString == null) || (paramString.equals("0")) || (paramString.length() < 4))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dating", 2, "getFaceDrawable, " + paramString);
      }
      localObject1 = ImageUtil.b();
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (paramQQAppInterface == null);
      localObject1 = localObject2;
    } while (paramFaceDecoder == null);
    paramQQAppInterface = paramFaceDecoder.a(32, paramString, paramInt);
    if (paramQQAppInterface == null)
    {
      if (!paramFaceDecoder.a())
      {
        a("getFaceDrawable", new Object[] { "request decode: ", paramString });
        paramFaceDecoder.a(paramString, paramInt, true, false);
      }
      return ImageUtil.b();
    }
    return new BitmapDrawable(BaseApplication.getContext().getResources(), paramQQAppInterface);
  }
  
  public static Drawable a(String paramString, FaceDecoder paramFaceDecoder, int paramInt)
  {
    if ((paramInt == 0) || (paramString == null) || (paramString.equals("0")) || (paramString.length() < 4)) {
      return ImageUtil.b();
    }
    if (paramFaceDecoder != null) {}
    for (Bitmap localBitmap = paramFaceDecoder.a(paramInt, paramString);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        if ((paramFaceDecoder != null) && (!paramFaceDecoder.a())) {
          paramFaceDecoder.a(paramString, paramInt, true, (byte)2);
        }
        if (paramInt == 4) {
          return ImageUtil.c();
        }
        if (paramInt == 101) {
          return ImageUtil.d();
        }
        return ImageUtil.b();
      }
      return new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap);
    }
  }
  
  public static appoint_define.AppointID a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0)
      {
        localObject1 = new appoint_define.AppointID();
        ((appoint_define.AppointID)localObject1).str_request_id.set(paramString);
      }
    }
    return localObject1;
  }
  
  public static appoint_define.DateComment a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || ((paramBoolean) && ((paramLong == 0L) || (TextUtils.isEmpty(paramString3))))) {
      paramString1 = null;
    }
    appoint_define.DateComment localDateComment;
    do
    {
      return paramString1;
      localDateComment = new appoint_define.DateComment();
      paramString1 = a(paramString1);
      localDateComment.msg_appoint_id.set(paramString1);
      localDateComment.uint32_time.set(paramInt);
      paramString1 = DatingComment.a(paramString2);
      localDateComment.msg_content.set(paramString1);
      paramString1 = localDateComment;
    } while (!paramBoolean);
    paramString1 = new appoint_define.ReplyInfo();
    paramString1.str_comment_id.set(paramString3);
    paramString2 = new appoint_define.StrangerInfo();
    paramString2.uint64_tinyid.set(paramLong);
    paramString1.msg_stranger_info.set(paramString2);
    localDateComment.msg_reply_info.set(paramString1);
    return localDateComment;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str = "";
    StringBuilder localStringBuilder;
    if (paramInt1 == 0)
    {
      str = "人看过";
      localStringBuilder = new StringBuilder();
      if (paramInt2 < 1000000) {
        break label74;
      }
      localStringBuilder.append(paramInt2 / 10000);
      localStringBuilder.append("万");
    }
    for (;;)
    {
      localStringBuilder.append(str);
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        str = "条评论";
        break;
      }
      if (paramInt1 != 2) {
        break;
      }
      str = "人报名";
      break;
      label74:
      localStringBuilder.append(paramInt2);
    }
  }
  
  public static String a(long paramLong)
  {
    long l = System.currentTimeMillis();
    Object localObject = Long.valueOf(1000L * paramLong);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(((Long)localObject).longValue());
    int i = (int)(Long.valueOf(l).longValue() / 86400000L);
    int j = (int)(((Long)localObject).longValue() / 86400000L);
    if (j == i) {
      i = 2131367164;
    }
    for (;;)
    {
      if (i != -1)
      {
        localObject = BaseApplication.getContext().getResources().getString(i);
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
        return (String)localObject + " " + localSimpleDateFormat.format(localCalendar.getTime());
        if (j == i + 1)
        {
          i = 2131367162;
          continue;
        }
        if (j == i + 2)
        {
          i = 2131367163;
          continue;
        }
        if (j == i - 1)
        {
          i = 2131367165;
          continue;
        }
        if (j == i - 2) {
          i = 2131367166;
        }
      }
      else
      {
        return new SimpleDateFormat("M月d日 H点mm分").format(localCalendar.getTime());
      }
      i = -1;
    }
  }
  
  public static String a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = Long.valueOf(NetConnInfoCenter.getServerTimeMillis());
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(((Long)localObject1).longValue());
    Long localLong = Long.valueOf(1000L * paramLong);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(localLong.longValue());
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1970, 0, 1, 0, 0, 0);
    long l = localCalendar2.getTime().getTime() - 1000L;
    paramLong = (((Long)localObject1).longValue() - l) / 1000L / 86400L;
    l = (localLong.longValue() - l) / 1000L / 86400L;
    int i = -1;
    int j = 0;
    if (l == paramLong) {
      i = 2131367164;
    }
    while (paramInt == 5) {
      if (i != -1)
      {
        return BaseApplication.getContext().getResources().getString(i);
        if (l == 1L + paramLong) {
          i = 2131367162;
        } else if (l == 2L + paramLong) {
          i = 2131367163;
        } else if (l == paramLong - 1L) {
          i = 2131367165;
        } else if (l == paramLong - 2L) {
          i = 2131367166;
        } else if (localCalendar1.get(1) == ((Calendar)localObject2).get(1)) {
          j = 1;
        } else {
          j = 0;
        }
      }
      else
      {
        if (j == 0)
        {
          if (paramBoolean) {}
          for (localObject1 = "yyyy年M月d日";; localObject1 = "yyyy-MM-dd")
          {
            localObject1 = new SimpleDateFormat((String)localObject1);
            return ((SimpleDateFormat)localObject1).format(localCalendar1.getTime());
          }
        }
        if (paramBoolean) {}
        for (localObject1 = "M月d日";; localObject1 = "MM-dd")
        {
          localObject1 = new SimpleDateFormat((String)localObject1);
          break;
        }
      }
    }
    if (i != -1)
    {
      localObject2 = BaseApplication.getContext();
      if (paramBoolean) {}
      for (localObject1 = ",H点m分";; localObject1 = " HH:mm")
      {
        localObject1 = new SimpleDateFormat((String)localObject1);
        return ((Context)localObject2).getResources().getString(i) + ((SimpleDateFormat)localObject1).format(localCalendar1.getTime());
      }
    }
    if (j == 0)
    {
      if (paramBoolean) {}
      for (localObject1 = "yyyy年M月d日,HH点mm分";; localObject1 = "yyyy-MM-dd HH:mm")
      {
        localObject1 = new SimpleDateFormat((String)localObject1);
        return ((SimpleDateFormat)localObject1).format(localCalendar1.getTime());
      }
    }
    if (paramBoolean) {}
    for (localObject1 = "M月d日,H点m分";; localObject1 = "MM-dd HH:mm")
    {
      localObject1 = new SimpleDateFormat((String)localObject1);
      break;
    }
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    paramLong = 1000L * paramLong;
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = (int)(l / 86400000L);
    int j = (int)(paramLong / 86400000L);
    int k = (int)(l - paramLong) / 86400000;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    if (k < 0)
    {
      if (paramBoolean) {}
      for (localObject = "yyyy年M月d日 H点m分";; localObject = "yyyy-MM-dd HH:mm") {
        return new SimpleDateFormat((String)localObject).format(localCalendar.getTime());
      }
    }
    if (k == 0)
    {
      i = (int)((l - paramLong) / 3600000L);
      if (i <= 0) {
        return "刚刚";
      }
      return String.format("%d小时前", new Object[] { Integer.valueOf(i) });
    }
    if (i == j + 1)
    {
      if (paramBoolean) {}
      for (localObject = "H点m分";; localObject = "HH:mm") {
        return String.format("昨天 %s", new Object[] { new SimpleDateFormat((String)localObject).format(localCalendar.getTime()) });
      }
    }
    if (i == j + 2)
    {
      if (paramBoolean) {}
      for (localObject = "H点m分";; localObject = "HH:mm") {
        return String.format("前天 %s", new Object[] { new SimpleDateFormat((String)localObject).format(localCalendar.getTime()) });
      }
    }
    if (localCalendar.get(1) == ((Calendar)localObject).get(1))
    {
      if (paramBoolean) {}
      for (localObject = "M月d日 H点m分";; localObject = "MM-dd HH:mm") {
        return new SimpleDateFormat((String)localObject).format(localCalendar.getTime());
      }
    }
    if (paramBoolean) {}
    for (localObject = "yyyy年M月d日 H点m分";; localObject = "yyyy-MM-dd HH:mm") {
      return new SimpleDateFormat((String)localObject).format(localCalendar.getTime());
    }
  }
  
  public static String a(Context paramContext, Paint paramPaint, int paramInt, String paramString)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i = paramContext.widthPixels;
    float f = paramInt;
    paramInt = i - (int)(paramContext.density * f);
    paramContext = paramString;
    if (paramPaint != null)
    {
      paramContext = paramString;
      if (paramInt > 0)
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label53;
        }
        paramContext = paramString;
      }
    }
    label53:
    String[] arrayOfString;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return paramContext;
              paramContext = paramString;
            } while ((int)paramPaint.measureText(paramString) <= paramInt);
            arrayOfString = paramString.split("-");
            paramContext = paramString;
          } while (arrayOfString.length < 2);
          if (arrayOfString[0].length() > 2)
          {
            arrayOfString[0] = (arrayOfString[0].substring(0, 2) + "…");
            paramString = arrayOfString[0] + "-" + arrayOfString[1];
          }
          paramContext = paramString;
        } while ((int)paramPaint.measureText(paramString) <= paramInt);
        paramPaint = arrayOfString[1].split(",");
        paramContext = paramString;
      } while (paramPaint.length < 2);
      paramContext = paramString;
    } while (paramPaint[0].length() <= 2);
    paramPaint[0] = (paramPaint[0].substring(0, 2) + "…");
    return arrayOfString[0] + "-" + paramPaint[0] + "," + paramPaint[1];
  }
  
  public static String a(appoint_define.AppointID paramAppointID)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAppointID != null)
    {
      localObject1 = localObject2;
      if (paramAppointID.str_request_id != null)
      {
        localObject1 = localObject2;
        if (paramAppointID.str_request_id.has()) {
          localObject1 = paramAppointID.str_request_id.get();
        }
      }
    }
    return localObject1;
  }
  
  public static String a(appoint_define.AppointInfo paramAppointInfo)
  {
    if ((paramAppointInfo != null) && (paramAppointInfo.msg_appoint_id.has()))
    {
      paramAppointInfo = (appoint_define.AppointID)paramAppointInfo.msg_appoint_id.get();
      if (paramAppointInfo != null) {
        return a(paramAppointInfo);
      }
    }
    return null;
  }
  
  public static String a(appoint_define.LocaleInfo paramLocaleInfo, int paramInt)
  {
    String str1;
    String str2;
    label36:
    String str3;
    if (paramLocaleInfo.str_poi.has())
    {
      str1 = paramLocaleInfo.str_poi.get();
      if (!paramLocaleInfo.str_city.has()) {
        break label89;
      }
      str2 = paramLocaleInfo.str_city.get();
      if (!paramLocaleInfo.str_region.has()) {
        break label95;
      }
      str3 = paramLocaleInfo.str_region.get();
      label55:
      if (!paramLocaleInfo.str_province.has()) {
        break label102;
      }
    }
    label89:
    label95:
    label102:
    for (paramLocaleInfo = paramLocaleInfo.str_province.get();; paramLocaleInfo = "")
    {
      return a(str1, str2, str3, paramLocaleInfo, paramInt);
      str1 = "";
      break;
      str2 = "";
      break label36;
      str3 = "";
      break label55;
    }
  }
  
  public static String a(appoint_define.TravelInfo paramTravelInfo)
  {
    if (paramTravelInfo == null) {
      return "";
    }
    Object localObject = (appoint_define.LocaleInfo)paramTravelInfo.msg_depart_locale.get();
    String str1 = ((appoint_define.LocaleInfo)localObject).str_poi.get();
    String str2 = ((appoint_define.LocaleInfo)localObject).str_region.get();
    String str3 = ((appoint_define.LocaleInfo)localObject).str_city.get();
    String str4 = ((appoint_define.LocaleInfo)localObject).str_province.get();
    localObject = ((appoint_define.LocaleInfo)localObject).str_country.get();
    paramTravelInfo = (appoint_define.LocaleInfo)paramTravelInfo.msg_destination.get();
    String str5 = paramTravelInfo.str_poi.get();
    String str6 = paramTravelInfo.str_region.get();
    String str7 = paramTravelInfo.str_city.get();
    String str8 = paramTravelInfo.str_province.get();
    return a((String)localObject, str4, str3, str2, str1, paramTravelInfo.str_country.get(), str8, str7, str6, str5);
  }
  
  public static String a(DatingInfo paramDatingInfo)
  {
    if (paramDatingInfo == null) {
      return "";
    }
    String str1 = paramDatingInfo.departPoi;
    String str2 = paramDatingInfo.departRegion;
    String str3 = paramDatingInfo.departCity;
    String str4 = paramDatingInfo.departProvince;
    String str5 = paramDatingInfo.departCountry;
    String str6 = paramDatingInfo.destPoi;
    String str7 = paramDatingInfo.destRegion;
    String str8 = paramDatingInfo.destCity;
    String str9 = paramDatingInfo.destProvince;
    return a(str5, str4, str3, str2, str1, paramDatingInfo.destCountry, str9, str8, str7, str6);
  }
  
  public static String a(Object paramObject)
  {
    String str = null;
    if ((paramObject instanceof cmd0x7de.UserProfile)) {
      str = a((cmd0x7de.UserProfile)paramObject);
    }
    do
    {
      return str;
      if ((paramObject instanceof cmd0x7cd.AppointBrife)) {
        return a((cmd0x7cd.AppointBrife)paramObject);
      }
      if ((paramObject instanceof appoint_define.AppointInfo)) {
        return a((appoint_define.AppointInfo)paramObject);
      }
    } while (!(paramObject instanceof cmd0x7ce.AppintDetail));
    return a((cmd0x7ce.AppintDetail)paramObject);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        localStringBuilder.append(paramString2 + ",");
      }
      localStringBuilder.append(paramString1);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramString2))
      {
        localStringBuilder.append(paramString2);
        if ((!TextUtils.isEmpty(paramString3)) && (paramInt != 2)) {
          localStringBuilder.append("," + paramString3);
        }
      }
      else if (!TextUtils.isEmpty(paramString4))
      {
        localStringBuilder.append(paramString4);
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    if (TextUtils.isEmpty(paramString10)) {}
    while ((!TextUtils.isEmpty(paramString3)) && (paramString3.equals(paramString8)))
    {
      paramString10 = paramString4;
      paramString5 = paramString9;
      if (TextUtils.isEmpty(paramString4)) {
        break label125;
      }
      paramString10 = paramString4;
      paramString5 = paramString9;
      if (TextUtils.isEmpty(paramString9)) {
        break label125;
      }
      return paramString4 + "-" + paramString9;
      paramString9 = paramString10;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramString4 = paramString3;
    }
    paramString10 = paramString4;
    paramString5 = paramString9;
    if (!TextUtils.isEmpty(paramString8))
    {
      if (TextUtils.isEmpty(paramString9))
      {
        paramString5 = paramString8;
        paramString10 = paramString4;
      }
    }
    else {
      label125:
      if (!TextUtils.isEmpty(paramString10)) {
        break label280;
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString3)) {}
      for (;;)
      {
        if (TextUtils.isEmpty(paramString2)) {}
        for (;;)
        {
          if (TextUtils.isEmpty(paramString5)) {}
          for (;;)
          {
            if (TextUtils.isEmpty(paramString8)) {}
            for (;;)
            {
              if (TextUtils.isEmpty(paramString7)) {}
              for (;;)
              {
                if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString6)))
                {
                  return "";
                  paramString5 = paramString8 + "," + paramString9;
                  paramString10 = paramString4;
                  break;
                }
                return paramString1 + "-" + paramString6;
                paramString6 = paramString7;
              }
              paramString7 = paramString8;
            }
            paramString8 = paramString5;
          }
          paramString1 = paramString2;
        }
        paramString2 = paramString3;
      }
      label280:
      paramString3 = paramString10;
    }
  }
  
  public static String a(cmd0x7cd.AppointBrife paramAppointBrife)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAppointBrife != null)
    {
      localObject1 = localObject2;
      if (paramAppointBrife.msg_appoints_info.has()) {
        localObject1 = a((appoint_define.AppointInfo)paramAppointBrife.msg_appoints_info.get());
      }
    }
    return localObject1;
  }
  
  public static String a(cmd0x7ce.AppintDetail paramAppintDetail)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAppintDetail != null)
    {
      localObject1 = localObject2;
      if (paramAppintDetail.msg_appoints_info.has()) {
        localObject1 = a((appoint_define.AppointInfo)paramAppintDetail.msg_appoints_info.get());
      }
    }
    return localObject1;
  }
  
  public static String a(cmd0x7de.UserProfile paramUserProfile)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramUserProfile != null)
    {
      localObject1 = localObject2;
      if (paramUserProfile.msg_appoints_info.has()) {
        localObject1 = a((appoint_define.AppointInfo)paramUserProfile.msg_appoints_info.get());
      }
    }
    return localObject1;
  }
  
  public static cmd0x7ce.AppintDetail a(List paramList, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        cmd0x7ce.AppintDetail localAppintDetail = (cmd0x7ce.AppintDetail)paramList.next();
        if (paramString.equals(a(localAppintDetail))) {
          return localAppintDetail;
        }
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, long paramLong, String paramString1, byte[] paramArrayOfByte, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    a("openDatingProfileCard", new Object[] { paramContext, Long.valueOf(paramLong), paramString1, paramArrayOfByte, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(String.valueOf(0), 75);
    localAllInOne.h = paramString2;
    localAllInOne.jdField_b_of_type_Int = paramInt2;
    localAllInOne.a = ((byte)paramInt3);
    localAllInOne.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localAllInOne.g = paramInt1;
    paramArrayOfByte = new Intent(paramContext, NearbyPeopleProfileActivity.class);
    paramArrayOfByte.putExtra("AllInOne", localAllInOne);
    paramArrayOfByte.putExtra("param_mode", 3);
    paramArrayOfByte.putExtra("param_tiny_id", paramLong);
    paramArrayOfByte.putExtra("param_dating_id", paramString1);
    paramArrayOfByte.putExtra("param_dating_subject", paramInt4);
    paramArrayOfByte.putExtra("param_dating_pub", paramBoolean);
    paramContext.startActivity(paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    int i = 1010;
    if (RecentUtil.a(paramQQAppInterface, paramString1)) {
      i = 0;
    }
    paramQQAppInterface = new Intent(paramContext, ChatActivity.class);
    paramQQAppInterface.putExtra("uin", paramString1);
    paramQQAppInterface.putExtra("uintype", i);
    paramQQAppInterface.putExtra("uinname", paramString2);
    paramQQAppInterface.putExtra("rich_date_sig", paramArrayOfByte);
    paramQQAppInterface.putExtra("dating_from_id", paramInt);
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public static void a(DatingInfo paramDatingInfo, appoint_define.AppointInfo paramAppointInfo)
  {
    if ((paramDatingInfo == null) || (paramAppointInfo == null)) {}
    label1174:
    label1179:
    label1181:
    label1194:
    label1196:
    label1204:
    for (;;)
    {
      return;
      if (paramAppointInfo.msg_appoint_id.has()) {
        paramDatingInfo.datingId = a((appoint_define.AppointID)paramAppointInfo.msg_appoint_id.get());
      }
      if (paramAppointInfo.str_join_wording.has()) {
        paramDatingInfo.datingApplyWording = paramAppointInfo.str_join_wording.get();
      }
      if (paramAppointInfo.str_view_wording.has()) {
        paramDatingInfo.datingVisitWording = paramAppointInfo.str_view_wording.get();
      }
      if (paramAppointInfo.str_comment_wording.has()) {
        paramDatingInfo.datingCommentWording = paramAppointInfo.str_comment_wording.get();
      }
      if (paramAppointInfo.uint32_join.has()) {
        paramDatingInfo.datingApplyNum = paramAppointInfo.uint32_join.get();
      }
      if (paramAppointInfo.uint32_view.has()) {
        paramDatingInfo.datingVisitNum = paramAppointInfo.uint32_view.get();
      }
      if (paramAppointInfo.uint32_comment_num.has()) {
        paramDatingInfo.datingCommentNum = paramAppointInfo.uint32_comment_num.get();
      }
      if (paramAppointInfo.uint32_owner.has()) {
        paramDatingInfo.owner = paramAppointInfo.uint32_owner.get();
      }
      if (paramAppointInfo.uint32_appoint_status.has()) {
        paramDatingInfo.datingStatus = paramAppointInfo.uint32_appoint_status.get();
      }
      if (paramAppointInfo.msg_appointment.has()) {}
      for (paramAppointInfo = (appoint_define.AppointContent)paramAppointInfo.msg_appointment.get();; paramAppointInfo = null)
      {
        if (paramAppointInfo == null) {
          break label1204;
        }
        if (paramAppointInfo.uint32_pay_type.has()) {
          paramDatingInfo.datingPayType = paramAppointInfo.uint32_pay_type.get();
        }
        if (paramAppointInfo.str_appoint_introduce.has()) {
          paramDatingInfo.datingIntroduce = paramAppointInfo.str_appoint_introduce.get();
        }
        if (paramAppointInfo.uint32_appoint_gender.has()) {
          paramDatingInfo.datingGender = paramAppointInfo.uint32_appoint_gender.get();
        }
        if (paramAppointInfo.uint32_appoint_subject.has()) {
          paramDatingInfo.datingSubject = paramAppointInfo.uint32_appoint_subject.get();
        }
        if (paramAppointInfo.uint32_appoint_date.has())
        {
          paramDatingInfo.datingTime = paramAppointInfo.uint32_appoint_date.get();
          if (paramDatingInfo.datingTime == 0L) {
            paramDatingInfo.strDatingTime = "";
          }
        }
        else
        {
          label350:
          if (!paramAppointInfo.msg_appoint_address.has()) {
            break label1196;
          }
        }
        for (Object localObject = (appoint_define.AddressInfo)paramAppointInfo.msg_appoint_address.get();; localObject = null)
        {
          if (localObject != null)
          {
            if (((appoint_define.AddressInfo)localObject).str_company_addr.has()) {
              paramDatingInfo.addressCompanyAddr = ((appoint_define.AddressInfo)localObject).str_company_addr.get();
            }
            if (((appoint_define.AddressInfo)localObject).str_company_name.has()) {
              paramDatingInfo.addressCompanyName = ((appoint_define.AddressInfo)localObject).str_company_name.get();
            }
            if (((appoint_define.AddressInfo)localObject).str_company_pic_url.has()) {
              paramDatingInfo.addressCompanyPicUrl = ((appoint_define.AddressInfo)localObject).str_company_pic_url.get();
            }
            if (((appoint_define.AddressInfo)localObject).str_company_url.has()) {
              paramDatingInfo.addressCompanyUrl = ((appoint_define.AddressInfo)localObject).str_company_url.get();
            }
            if (((appoint_define.AddressInfo)localObject).str_company_zone.has()) {
              paramDatingInfo.addressCompanyZone = ((appoint_define.AddressInfo)localObject).str_company_zone.get();
            }
          }
          if (paramAppointInfo.msg_travel_info.has()) {}
          for (paramAppointInfo = (appoint_define.TravelInfo)paramAppointInfo.msg_travel_info.get();; paramAppointInfo = null)
          {
            if (paramAppointInfo == null) {
              break label1194;
            }
            if (paramAppointInfo.uint32_vehicle.has()) {
              paramDatingInfo.vehicle = paramAppointInfo.uint32_vehicle.get();
            }
            if (paramAppointInfo.uint32_partner_count.has()) {
              paramDatingInfo.partnerCount = paramAppointInfo.uint32_partner_count.get();
            }
            if (paramAppointInfo.str_place_pic_url.has()) {
              paramDatingInfo.placePicUrl = paramAppointInfo.str_place_pic_url.get();
            }
            if (paramAppointInfo.str_place_url.has()) {
              paramDatingInfo.placeUrl = paramAppointInfo.str_place_url.get();
            }
            if (paramAppointInfo.msg_depart_locale.has()) {}
            for (localObject = (appoint_define.LocaleInfo)paramAppointInfo.msg_depart_locale.get();; localObject = null)
            {
              if (localObject != null)
              {
                if (((appoint_define.LocaleInfo)localObject).str_name.has()) {
                  paramDatingInfo.departName = ((appoint_define.LocaleInfo)localObject).str_name.get();
                }
                if (((appoint_define.LocaleInfo)localObject).str_country.has()) {
                  paramDatingInfo.departCountry = ((appoint_define.LocaleInfo)localObject).str_country.get();
                }
                if (((appoint_define.LocaleInfo)localObject).str_province.has()) {
                  paramDatingInfo.departProvince = ((appoint_define.LocaleInfo)localObject).str_province.get();
                }
                if (((appoint_define.LocaleInfo)localObject).str_city.has()) {
                  paramDatingInfo.departCity = ((appoint_define.LocaleInfo)localObject).str_city.get();
                }
                if (((appoint_define.LocaleInfo)localObject).str_region.has()) {
                  paramDatingInfo.departRegion = ((appoint_define.LocaleInfo)localObject).str_region.get();
                }
                if (((appoint_define.LocaleInfo)localObject).str_poi.has()) {
                  paramDatingInfo.departPoi = ((appoint_define.LocaleInfo)localObject).str_poi.get();
                }
                if (((appoint_define.LocaleInfo)localObject).str_address.has()) {
                  paramDatingInfo.departAddress = ((appoint_define.LocaleInfo)localObject).str_address.get();
                }
                if (!((appoint_define.LocaleInfo)localObject).msg_gps.has()) {
                  break label1181;
                }
              }
              for (localObject = (appoint_define.GPS)((appoint_define.LocaleInfo)localObject).msg_gps.get();; localObject = null)
              {
                if (localObject != null)
                {
                  if (((appoint_define.GPS)localObject).int32_lat.has()) {
                    paramDatingInfo.departLat = ((appoint_define.GPS)localObject).int32_lat.get();
                  }
                  if (((appoint_define.GPS)localObject).int32_lon.has()) {
                    paramDatingInfo.departLon = ((appoint_define.GPS)localObject).int32_lon.get();
                  }
                  if (((appoint_define.GPS)localObject).int32_alt.has()) {
                    paramDatingInfo.departAlt = ((appoint_define.GPS)localObject).int32_alt.get();
                  }
                  if (((appoint_define.GPS)localObject).int32_type.has()) {
                    paramDatingInfo.departType = ((appoint_define.GPS)localObject).int32_type.get();
                  }
                }
                if (paramAppointInfo.msg_destination.has()) {}
                for (paramAppointInfo = (appoint_define.LocaleInfo)paramAppointInfo.msg_destination.get();; paramAppointInfo = null)
                {
                  if (paramAppointInfo == null) {
                    break label1179;
                  }
                  if (paramAppointInfo.str_name.has()) {
                    paramDatingInfo.destName = paramAppointInfo.str_name.get();
                  }
                  if (paramAppointInfo.str_country.has()) {
                    paramDatingInfo.destCountry = paramAppointInfo.str_country.get();
                  }
                  if (paramAppointInfo.str_province.has()) {
                    paramDatingInfo.destProvince = paramAppointInfo.str_province.get();
                  }
                  if (paramAppointInfo.str_city.has()) {
                    paramDatingInfo.destCity = paramAppointInfo.str_city.get();
                  }
                  if (paramAppointInfo.str_region.has()) {
                    paramDatingInfo.destRegion = paramAppointInfo.str_region.get();
                  }
                  if (paramAppointInfo.str_poi.has()) {
                    paramDatingInfo.destPoi = paramAppointInfo.str_poi.get();
                  }
                  if (paramAppointInfo.str_address.has()) {
                    paramDatingInfo.destAddress = paramAppointInfo.str_address.get();
                  }
                  if (paramAppointInfo.msg_gps.has()) {}
                  for (paramAppointInfo = (appoint_define.GPS)paramAppointInfo.msg_gps.get();; paramAppointInfo = null)
                  {
                    if (paramAppointInfo == null) {
                      break label1174;
                    }
                    if (paramAppointInfo.int32_lat.has()) {
                      paramDatingInfo.destLat = paramAppointInfo.int32_lat.get();
                    }
                    if (paramAppointInfo.int32_lon.has()) {
                      paramDatingInfo.destLon = paramAppointInfo.int32_lon.get();
                    }
                    if (paramAppointInfo.int32_alt.has()) {
                      paramDatingInfo.destAlt = paramAppointInfo.int32_alt.get();
                    }
                    if (!paramAppointInfo.int32_type.has()) {
                      break;
                    }
                    paramDatingInfo.destType = paramAppointInfo.int32_type.get();
                    return;
                    paramDatingInfo.strDatingTime = a(paramDatingInfo.datingTime, paramDatingInfo.datingSubject, false);
                    break label350;
                  }
                  break;
                }
                break;
              }
            }
          }
          break;
        }
      }
    }
  }
  
  public static void a(DatingInfo paramDatingInfo, appoint_define.PublisherInfo paramPublisherInfo)
  {
    if ((paramDatingInfo == null) || (paramPublisherInfo == null)) {}
    do
    {
      return;
      if (paramPublisherInfo.str_constellation.has()) {
        paramDatingInfo.publisherConstellation = paramPublisherInfo.str_constellation.get();
      }
      if (paramPublisherInfo.str_distance.has()) {
        paramDatingInfo.publisherDistance = paramPublisherInfo.str_distance.get();
      }
      if (paramPublisherInfo.str_nickname.has()) {
        paramDatingInfo.publisherNickname = paramPublisherInfo.str_nickname.get();
      }
      if (paramPublisherInfo.uint32_age.has()) {
        paramDatingInfo.publisherAge = paramPublisherInfo.uint32_age.get();
      }
      if (paramPublisherInfo.uint32_gender.has()) {
        paramDatingInfo.publisherGender = paramPublisherInfo.uint32_gender.get();
      }
      if (paramPublisherInfo.uint32_profession.has()) {
        paramDatingInfo.publisherProfession = paramPublisherInfo.uint32_profession.get();
      }
      if (paramPublisherInfo.uint64_tinyid.has()) {
        paramDatingInfo.publisherID = paramPublisherInfo.uint64_tinyid.get();
      }
      if (paramPublisherInfo.uint32_marriage.has()) {
        paramDatingInfo.publisherEmo = paramPublisherInfo.uint32_marriage.get();
      }
      if (paramPublisherInfo.str_vipinfo.has()) {
        paramDatingInfo.publisherVip = paramPublisherInfo.str_vipinfo.get();
      }
    } while (!paramPublisherInfo.uint32_recommend.has());
    paramDatingInfo.publisherNBflag = paramPublisherInfo.uint32_recommend.get();
  }
  
  public static void a(DatingInfo paramDatingInfo, Object paramObject)
  {
    if ((paramObject instanceof cmd0x7de.UserProfile)) {
      a(paramDatingInfo, (cmd0x7de.UserProfile)paramObject);
    }
    do
    {
      return;
      if ((paramObject instanceof cmd0x7cd.AppointBrife))
      {
        a(paramDatingInfo, (cmd0x7cd.AppointBrife)paramObject);
        return;
      }
    } while (!(paramObject instanceof appoint_define.AppointInfo));
    a(paramDatingInfo, (appoint_define.AppointInfo)paramObject);
  }
  
  public static void a(DatingInfo paramDatingInfo, cmd0x7cd.AppointBrife paramAppointBrife)
  {
    if ((paramDatingInfo == null) || (paramAppointBrife == null)) {}
    do
    {
      do
      {
        return;
        if (paramAppointBrife.msg_appoints_info.has())
        {
          appoint_define.AppointInfo localAppointInfo = (appoint_define.AppointInfo)paramAppointBrife.msg_appoints_info.get();
          if (localAppointInfo != null) {
            a(paramDatingInfo, localAppointInfo);
          }
        }
      } while (!paramAppointBrife.msg_publisher_info.has());
      paramAppointBrife = (appoint_define.PublisherInfo)paramAppointBrife.msg_publisher_info.get();
    } while (paramAppointBrife == null);
    a(paramDatingInfo, paramAppointBrife);
  }
  
  public static void a(DatingInfo paramDatingInfo, cmd0x7ce.AppintDetail paramAppintDetail)
  {
    if ((paramDatingInfo == null) || (paramAppintDetail == null)) {
      return;
    }
    if (paramAppintDetail.msg_appoints_info.has()) {}
    for (Object localObject = (appoint_define.AppointInfo)paramAppintDetail.msg_appoints_info.get();; localObject = null)
    {
      if (localObject != null) {
        a(paramDatingInfo, (appoint_define.AppointInfo)localObject);
      }
      if (paramAppintDetail.msg_publisher_info.has()) {}
      for (localObject = (appoint_define.PublisherInfo)paramAppintDetail.msg_publisher_info.get();; localObject = null)
      {
        if (localObject != null) {
          a(paramDatingInfo, (appoint_define.PublisherInfo)localObject);
        }
        if (paramAppintDetail.str_aio_errmsg.has()) {
          paramDatingInfo.detailAioTip = paramAppintDetail.str_aio_errmsg.get();
        }
        if (paramAppintDetail.uint32_can_aio.has()) {
          paramDatingInfo.detailCanAio = paramAppintDetail.uint32_can_aio.get();
        }
        if (paramAppintDetail.str_profile_errmsg.has()) {
          paramDatingInfo.detailProfileTip = paramAppintDetail.str_profile_errmsg.get();
        }
        if (paramAppintDetail.uint32_can_profile.has()) {
          paramDatingInfo.detailCanProfile = paramAppintDetail.uint32_can_profile.get();
        }
        if (paramAppintDetail.bytes_SigC2C.has()) {
          paramDatingInfo.detailSigC2C = paramAppintDetail.bytes_SigC2C.get().toByteArray();
        }
        if (paramAppintDetail.uint64_uin.has()) {
          paramDatingInfo.detailPubUin = paramAppintDetail.uint64_uin.get();
        }
        if (paramAppintDetail.uint32_me_join.has()) {
          paramDatingInfo.datingApply = paramAppintDetail.uint32_me_join.get();
        }
        if (paramAppintDetail.uint32_me_invited.has()) {
          paramDatingInfo.datingSelFlag = paramAppintDetail.uint32_me_invited.get();
        }
        if (!paramAppintDetail.uint32_limited.has()) {
          break;
        }
        paramDatingInfo.nLimit = paramAppintDetail.uint32_limited.get();
        return;
      }
    }
  }
  
  public static void a(DatingInfo paramDatingInfo, cmd0x7de.UserProfile paramUserProfile)
  {
    if ((paramDatingInfo == null) || (paramUserProfile == null)) {}
    do
    {
      do
      {
        return;
        if (paramUserProfile.msg_appoints_info.has())
        {
          appoint_define.AppointInfo localAppointInfo = (appoint_define.AppointInfo)paramUserProfile.msg_appoints_info.get();
          if (localAppointInfo != null) {
            a(paramDatingInfo, localAppointInfo);
          }
        }
      } while (!paramUserProfile.msg_publisher_info.has());
      paramUserProfile = (appoint_define.PublisherInfo)paramUserProfile.msg_publisher_info.get();
    } while (paramUserProfile == null);
    a(paramDatingInfo, paramUserProfile);
  }
  
  public static void a(String paramString, List paramList) {}
  
  public static void a(String paramString, Object... paramVarArgs) {}
  
  public static boolean a()
  {
    Context localContext = BaseApplication.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)localContext.getSystemService("phone");
    if (localTelephonyManager != null) {}
    try
    {
      CellLocation localCellLocation = localTelephonyManager.getCellLocation();
      int i = localTelephonyManager.getSimState();
      int j;
      if (i == 5) {
        j = 1;
      }
      for (;;)
      {
        try
        {
          bool = TextUtils.isEmpty(localTelephonyManager.getSubscriberId());
          if (bool) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException2)
        {
          boolean bool;
          i = 1;
          continue;
        }
        if ((j == 0) || (i == 0) || (localCellLocation != null)) {
          break label97;
        }
        bool = a(localContext);
        if (bool) {
          break label97;
        }
        return true;
        j = 0;
        continue;
        i = 0;
      }
      label97:
      return false;
    }
    catch (Exception localException1) {}
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on");
      return i == 1;
    }
    catch (Settings.SettingNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    return paramQQAppInterface.a().a(paramString, 1010).hasReply;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i("Q.dating", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUtil
 * JD-Core Version:    0.7.0.1
 */