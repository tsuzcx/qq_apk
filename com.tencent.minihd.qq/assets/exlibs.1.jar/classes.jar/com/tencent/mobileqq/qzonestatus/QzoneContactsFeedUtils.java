package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QzoneContactsFeedUtils
{
  private static final String jdField_a_of_type_JavaLangString = "req";
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  
  static
  {
    a = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  }
  
  public static newest_feeds_req a(int paramInt, long paramLong1, ArrayList paramArrayList, long paramLong2, String paramString)
  {
    return new newest_feeds_req(paramInt, paramLong1, paramArrayList, paramLong2, paramString);
  }
  
  public static newest_feeds_req a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return new newest_feeds_req();
    }
    paramIntent = paramIntent.getSerializableExtra("req");
    if ((paramIntent != null) && ((paramIntent instanceof newest_feeds_req))) {
      return (newest_feeds_req)paramIntent;
    }
    return new newest_feeds_req();
  }
  
  public static Intent a(Intent paramIntent, newest_feeds_req paramnewest_feeds_req)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("req", paramnewest_feeds_req);
    return localIntent;
  }
  
  public static String a(String paramString)
  {
    if ("".equals(paramString)) {}
    int j;
    int i;
    do
    {
      return null;
      int k = paramString.indexOf("uin:");
      j = paramString.indexOf(",");
      i = 0;
      if (k != -1) {
        i = k + 4;
      }
    } while ((i == 0) || (j == -1));
    return paramString.substring(i, j);
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null))
    {
      localObject = null;
      return localObject;
    }
    Matcher localMatcher = a.matcher(paramString);
    label123:
    for (;;)
    {
      localObject = paramString;
      if (!localMatcher.find()) {
        break;
      }
      String str = localMatcher.group();
      localObject = a(str);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(8);
        if (localFriendsManager != null)
        {
          localObject = localFriendsManager.c((String)localObject);
          if (localObject == null) {}
        }
      }
      for (localObject = ((Friends)localObject).getFriendNickWithAlias();; localObject = "")
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label123;
        }
        paramString.replace(str, "@" + (String)localObject);
        break;
      }
    }
  }
  
  public static ArrayList a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(49);
    if (paramQQAppInterface == null) {
      return null;
    }
    Object localObject = paramQQAppInterface.b();
    if (localObject != null)
    {
      paramQQAppInterface = new ArrayList(((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        if ((localFriends != null) && (Friends.isValidUin(localFriends.uin))) {
          paramQQAppInterface.add(Long.valueOf(Long.parseLong(localFriends.uin)));
        }
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      paramQQAppInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils
 * JD-Core Version:    0.7.0.1
 */