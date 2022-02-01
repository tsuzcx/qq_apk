package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatingInfo
  extends Entity
{
  @notColumn
  private static final int FLAG_MASK_COMMENT_NEW_OVER = 32;
  @notColumn
  private static final int FLAG_MASK_COMMENT_OLD_OVER = 16;
  @notColumn
  private static final int FLAG_MASK_STRANGER_NEW_OVER = 8;
  @notColumn
  private static final int FLAG_MASK_STRANGER_OLD_OVER = 4;
  @notColumn
  private static final int FLAG_MASK_VISIT_NEW_OVER = 2;
  @notColumn
  private static final int FLAG_MASK_VISIT_OLD_OVER = 1;
  @notColumn
  public static final int TYPE_COMMENT = 1;
  @notColumn
  public static final int TYPE_STRANGER = 2;
  @notColumn
  public static final int TYPE_VISIT = 0;
  public String addressCompanyAddr;
  public String addressCompanyName;
  public String addressCompanyPicUrl;
  public String addressCompanyUrl;
  public String addressCompanyZone;
  @notColumn
  private List commentList = new ArrayList(20);
  public String commentPacked;
  public int datingApply;
  public int datingApplyNum;
  public String datingApplyWording;
  public int datingCommentNum;
  public String datingCommentWording;
  public int datingGender;
  @unique
  public String datingId;
  public String datingIntroduce;
  public int datingPayType;
  public int datingSelFlag;
  public int datingStatus;
  public int datingSubject;
  public long datingTime;
  public int datingVisitNum;
  public String datingVisitWording;
  public String departAddress;
  public int departAlt;
  public String departCity;
  public String departCountry;
  public int departLat;
  public int departLon;
  public String departName;
  public String departPoi;
  public String departProvince;
  public String departRegion;
  public int departType;
  public String destAddress;
  public int destAlt;
  public String destCity;
  public String destCountry;
  public int destLat;
  public int destLon;
  public String destName;
  public String destPoi;
  public String destProvince;
  public String destRegion;
  public int destType;
  public String detailAioTip;
  public int detailCanAio;
  public int detailCanProfile;
  public String detailProfileTip;
  public long detailPubUin;
  public byte[] detailSigC2C;
  @notColumn
  public boolean isGetList = false;
  @notColumn
  public boolean isInit = false;
  @notColumn
  public int lastFrom = 0;
  @notColumn
  public long lastUpdateTime;
  public int nLimit;
  @notColumn
  private int nPrivateFlag = 0;
  public int owner;
  public int partnerCount;
  public String placePicUrl;
  public String placeUrl;
  public int publisherAge;
  public String publisherConstellation;
  public String publisherDistance;
  public int publisherEmo;
  public int publisherGender;
  public long publisherID;
  public int publisherNBflag;
  public String publisherNickname;
  public int publisherProfession;
  public String publisherVip;
  @notColumn
  public String strDatingTime;
  @notColumn
  private List strangerInfos = new ArrayList(20);
  public String strangerInfosPacked;
  public int vehicle;
  @notColumn
  private List visitorInfos = new ArrayList(20);
  public String visitorInfosPacked;
  
  public void addDatingComment(boolean paramBoolean, DatingComment paramDatingComment)
  {
    if ((paramDatingComment == null) || (TextUtils.isEmpty(paramDatingComment.a)))
    {
      DatingUtil.a("addDatingComment", new Object[] { "invalidate param", paramDatingComment });
      return;
    }
    for (;;)
    {
      synchronized (this.commentList)
      {
        ???.remove(paramDatingComment);
        if (paramBoolean)
        {
          ???.add(0, paramDatingComment);
          return;
        }
      }
      ???.add(paramDatingComment);
    }
  }
  
  public void addDatingComment(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      DatingUtil.a("addDatingComment", new Object[] { paramList });
      if (paramBoolean2) {
        this.commentList.clear();
      }
      return;
    }
    List localList = this.commentList;
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    for (;;)
    {
      try
      {
        localList.clear();
        localList.addAll(paramList);
        return;
      }
      finally {}
      localList.removeAll(paramList);
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        DatingComment localDatingComment = (DatingComment)paramList.next();
        if (localDatingComment != null)
        {
          localList.add(i, localDatingComment);
          i += 1;
        }
      }
      continue;
      localList.removeAll(paramList);
      localList.addAll(paramList);
    }
  }
  
  public void addStranger(boolean paramBoolean1, boolean paramBoolean2, DatingStranger paramDatingStranger)
  {
    if ((paramDatingStranger == null) || (paramDatingStranger.a == 0L))
    {
      DatingUtil.a("addStranger", new Object[] { "invalidate param", paramDatingStranger });
      return;
    }
    if (paramBoolean1) {}
    for (;;)
    {
      synchronized (this.visitorInfos)
      {
        ???.remove(paramDatingStranger);
        if (!paramBoolean2) {
          break label86;
        }
        ???.add(0, paramDatingStranger);
        return;
      }
      ??? = this.strangerInfos;
      continue;
      label86:
      ???.add(paramDatingStranger);
    }
  }
  
  public void addStranger(boolean paramBoolean1, boolean paramBoolean2, List paramList, boolean paramBoolean3)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      DatingUtil.a("addStranger", new Object[] { "invalidate param", paramList });
      if (paramBoolean3)
      {
        if (paramBoolean1) {
          this.visitorInfos.clear();
        }
      }
      else {
        return;
      }
      this.strangerInfos.clear();
      return;
    }
    List localList;
    if (paramBoolean1)
    {
      localList = this.visitorInfos;
      if (!paramBoolean2) {
        break label181;
      }
      if (!paramBoolean3) {
        break label120;
      }
    }
    for (;;)
    {
      try
      {
        localList.clear();
        localList.addAll(paramList);
        return;
      }
      finally {}
      localList = this.strangerInfos;
      break;
      label120:
      localList.removeAll(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DatingStranger localDatingStranger = (DatingStranger)paramList.next();
        if (localDatingStranger != null)
        {
          localList.add(i, localDatingStranger);
          i += 1;
        }
      }
      continue;
      label181:
      localList.removeAll(paramList);
      localList.addAll(paramList);
    }
  }
  
  public void delComment(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      synchronized (this.commentList)
      {
        if (!this.commentList.isEmpty())
        {
          Iterator localIterator = this.commentList.iterator();
          if (!localIterator.hasNext()) {
            break label117;
          }
          DatingComment localDatingComment = (DatingComment)localIterator.next();
          if ((localDatingComment == null) || (!paramString.equals(localDatingComment.a))) {
            continue;
          }
          paramString = localDatingComment;
          if (paramString != null)
          {
            this.commentList.remove(paramString);
            if (this.datingCommentNum >= 1) {
              this.datingCommentNum -= 1;
            }
          }
        }
        return;
      }
      label117:
      paramString = null;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (DatingInfo)paramObject;
    } while (((this.datingId != null) || (paramObject.datingId != null)) && ((this.datingId == null) || (!this.datingId.equals(paramObject.datingId))));
    return true;
  }
  
  public DatingComment getDatingComment(int paramInt, String paramString)
  {
    List localList = this.commentList;
    if (localList.isEmpty()) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (localList.size() <= 0) {
          break label150;
        }
        if (paramInt == 1)
        {
          paramString = (DatingComment)localList.get(0);
          return paramString;
        }
      }
      finally {}
      if (paramInt == 2)
      {
        paramString = (DatingComment)localList.get(localList.size() - 1);
      }
      else
      {
        if (!TextUtils.isEmpty(paramString))
        {
          Iterator localIterator = localList.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              DatingComment localDatingComment = (DatingComment)localIterator.next();
              if (localDatingComment != null)
              {
                boolean bool = paramString.equals(localDatingComment.a);
                if (bool)
                {
                  paramString = localDatingComment;
                  break;
                }
              }
            }
          }
        }
        label150:
        paramString = null;
      }
    }
  }
  
  public List getDatingComment(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
      return null;
    }
    List localList = this.commentList;
    if (localList.isEmpty()) {
      return null;
    }
    int k;
    int j;
    int i;
    try
    {
      k = localList.size();
      if (k <= 0) {
        break label205;
      }
      Iterator localIterator = localList.iterator();
      j = -1;
      DatingComment localDatingComment;
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localDatingComment = (DatingComment)localIterator.next();
          i = j + 1;
          j = i;
        } while (localDatingComment == null);
        j = i;
      } while (!paramString.equals(localDatingComment.a));
      paramString = localDatingComment;
      j = i;
    }
    finally {}
    if ((i >= 0) && (i <= j))
    {
      paramString = new ArrayList(paramInt1 + paramInt2);
      while (i <= j)
      {
        paramString.add(localList.get(i));
        i += 1;
      }
    }
    for (;;)
    {
      return paramString;
      label205:
      do
      {
        paramString = null;
        break;
        paramString = null;
        continue;
        j = -1;
        paramString = null;
      } while ((j < 0) || (paramString == null));
      if (paramInt1 <= 0) {
        i = j + 1;
      }
      for (;;)
      {
        if (paramInt2 > 0) {
          break label264;
        }
        j -= 1;
        break;
        if (j - paramInt1 < 0) {
          i = 0;
        } else {
          i = j - paramInt1;
        }
      }
      label264:
      if ((j + 1 + paramInt2 > k) || (paramInt2 - j - 1 > k))
      {
        j = k - 1;
        break;
      }
      j += paramInt2;
      break;
    }
  }
  
  public List getDatingComment(boolean paramBoolean, int paramInt)
  {
    int j = 0;
    if ((paramBoolean) && ((this.nPrivateFlag & 0x20) == 0))
    {
      DatingUtil.a("getDatingComment", new Object[] { "not contain first screen" });
      return null;
    }
    List localList = this.commentList;
    if (localList.isEmpty()) {
      return null;
    }
    int k;
    int i;
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        k = localList.size();
        if (paramInt <= 0) {
          break label152;
        }
        i = paramInt;
        if (paramInt > k) {
          i = k;
        }
        localArrayList = new ArrayList(i);
        if (i < k) {
          break;
        }
        localArrayList.addAll(localList);
        return localArrayList;
      }
      finally {}
      if (j < paramInt + i)
      {
        localArrayList.add(localList.get(j));
        j += 1;
        continue;
        label152:
        i = 20;
      }
    }
    if (paramBoolean) {}
    for (paramInt = j;; paramInt = k - i)
    {
      j = paramInt;
      break;
    }
  }
  
  public DatingStranger getStranger(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {}
    for (List localList = this.visitorInfos; localList.isEmpty(); localList = this.strangerInfos) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        i = localList.size();
        if (i <= 0) {
          break label154;
        }
        if (paramInt1 == 1)
        {
          DatingStranger localDatingStranger1 = (DatingStranger)localList.get(0);
          return localDatingStranger1;
        }
      }
      finally {}
      DatingStranger localDatingStranger2;
      if (paramInt1 == 2)
      {
        localDatingStranger2 = (DatingStranger)localList.get(i - 1);
      }
      else
      {
        Iterator localIterator = localList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localDatingStranger2 = (DatingStranger)localIterator.next();
            if (localDatingStranger2 != null)
            {
              paramInt1 = localDatingStranger2.f;
              if (paramInt1 == paramInt2) {
                break;
              }
            }
          }
        }
        label154:
        localDatingStranger2 = null;
      }
    }
  }
  
  public List getStranger(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = -1;
    if ((paramInt2 <= 0) && (paramInt3 <= 0)) {
      return null;
    }
    if (paramInt1 == -1) {
      return getStranger(paramBoolean, true, 20);
    }
    if (paramBoolean) {}
    for (List localList = this.visitorInfos; localList.isEmpty(); localList = this.strangerInfos) {
      return null;
    }
    int k;
    int j;
    Object localObject1;
    try
    {
      k = localList.size();
      j = i;
      if (k <= 0) {
        break label218;
      }
      Iterator localIterator = localList.iterator();
      do
      {
        do
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (DatingStranger)localIterator.next();
          j = i + 1;
          i = j;
        } while (localObject1 == null);
        i = j;
      } while (((DatingStranger)localObject1).f != paramInt1);
    }
    finally {}
    if ((paramInt1 >= 0) && (paramInt1 <= i))
    {
      localObject1 = new ArrayList(paramInt2 + paramInt3);
      while (paramInt1 <= i)
      {
        ((List)localObject1).add(localList.get(paramInt1));
        paramInt1 += 1;
      }
    }
    for (;;)
    {
      return localObject1;
      Object localObject3;
      label218:
      do
      {
        localObject3 = null;
        break;
        localObject3 = null;
      } while ((j < 0) || (localObject3 == null));
      if (paramInt2 <= 0) {
        paramInt1 = j + 1;
      }
      for (;;)
      {
        if (paramInt3 > 0) {
          break label274;
        }
        i = j - 1;
        break;
        if (j - paramInt2 < 0) {
          paramInt1 = 0;
        } else {
          paramInt1 = j - paramInt2;
        }
      }
      label274:
      if ((j + paramInt3 > k - 1) || (paramInt3 - j > k - 1))
      {
        i = k - 1;
        break;
      }
      i = j + paramInt3;
      break;
    }
  }
  
  public List getStranger(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int j = 0;
    if (paramBoolean1) {}
    for (int i = 2; (paramBoolean2) && ((i & this.nPrivateFlag) == 0); i = 8)
    {
      DatingUtil.a("getStranger", new Object[] { Boolean.valueOf(paramBoolean1), "not contain first screen" });
      return null;
    }
    if (paramBoolean1) {}
    for (List localList = this.visitorInfos; localList.isEmpty(); localList = this.strangerInfos) {
      return null;
    }
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        int k = localList.size();
        if (paramInt <= 0) {
          break label205;
        }
        i = paramInt;
        if (paramInt > k) {
          i = k;
        }
        localArrayList = new ArrayList(i);
        if (i < k) {
          break label212;
        }
        localArrayList.addAll(localList);
        return localArrayList;
      }
      finally {}
      if (j < paramInt + i)
      {
        localArrayList.add(localList.get(j));
        j += 1;
        continue;
        paramInt = localList.size() - i;
        break label219;
        label205:
        i = 20;
        continue;
        label212:
        if (paramBoolean2)
        {
          paramInt = j;
          label219:
          j = paramInt;
        }
      }
    }
  }
  
  public int hashCode()
  {
    if (TextUtils.isEmpty(this.datingId)) {
      return "".hashCode();
    }
    return this.datingId.hashCode();
  }
  
  public void init()
  {
    if (this.datingTime == 0L) {}
    for (this.strDatingTime = "";; this.strDatingTime = DatingUtil.a(this.datingTime, this.datingSubject, false))
    {
      DatingStranger.a(this.visitorInfos, this.visitorInfosPacked);
      this.nPrivateFlag |= 0x2;
      DatingComment.a(this.commentList, this.commentPacked);
      this.nPrivateFlag |= 0x20;
      DatingStranger.a(this.strangerInfos, this.strangerInfosPacked);
      this.nPrivateFlag |= 0x8;
      return;
    }
  }
  
  public boolean isCanMerge(int paramInt, boolean paramBoolean, List paramList)
  {
    Object localObject = null;
    boolean bool = false;
    if ((paramList == null) || (paramList.isEmpty())) {}
    List localList;
    do
    {
      return false;
      switch (paramInt)
      {
      default: 
        localList = null;
      }
    } while ((localList == null) || (localList.isEmpty()));
    for (;;)
    {
      try
      {
        if (!localList.isEmpty()) {
          break label134;
        }
        paramBoolean = bool;
        if (paramList.indexOf(localObject) != -1) {
          paramBoolean = true;
        }
        return paramBoolean;
      }
      finally {}
      localList = this.visitorInfos;
      break;
      localList = this.strangerInfos;
      break;
      localList = this.commentList;
      break;
      label134:
      if (paramBoolean) {
        localObject = localList.get(0);
      } else {
        localObject = localList.get(localList.size() - 1);
      }
    }
  }
  
  public boolean isDefaultValue()
  {
    boolean bool = false;
    if ((this.datingSubject == 0) || (this.datingTime == 0L)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isInCache(int paramInt, Object arg2)
  {
    int i;
    if (((paramInt == 0) || (paramInt == 2)) && ((??? instanceof Integer)))
    {
      i = ((Integer)???).intValue();
      if (paramInt != 0) {}
    }
    for (;;)
    {
      Object localObject3;
      synchronized (this.visitorInfos)
      {
        if (???.isEmpty()) {
          break label216;
        }
        Iterator localIterator = ???.iterator();
        if (!localIterator.hasNext()) {
          break label216;
        }
        localObject3 = (DatingStranger)localIterator.next();
        if ((localObject3 == null) || (((DatingStranger)localObject3).f != i)) {
          continue;
        }
        bool = true;
        return bool;
        ??? = this.strangerInfos;
      }
      if ((paramInt == 1) && ((??? instanceof String)))
      {
        String str = (String)???;
        for (;;)
        {
          synchronized (this.commentList)
          {
            if (!???.isEmpty())
            {
              localObject3 = ???.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                DatingComment localDatingComment = (DatingComment)((Iterator)localObject3).next();
                if ((localDatingComment == null) || (!str.equals(localDatingComment.a))) {
                  continue;
                }
                bool = true;
                return bool;
              }
            }
          }
          bool = false;
        }
      }
      return false;
      label216:
      boolean bool = false;
    }
  }
  
  public boolean isReachCacheOver(int paramInt, Object paramObject, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = isReachOver(paramInt, paramBoolean);
    if (!bool1) {
      return false;
    }
    List localList;
    switch (paramInt)
    {
    default: 
      localList = null;
      if (localList == null) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        paramInt = localList.indexOf(paramObject);
        if (paramBoolean)
        {
          if (paramInt == 0)
          {
            paramBoolean = true;
            return paramBoolean;
            if (paramInt == 0)
            {
              localList = this.visitorInfos;
              break;
            }
            localList = this.strangerInfos;
            continue;
            localList = this.commentList;
            break;
          }
          paramBoolean = false;
          continue;
        }
        if (!paramBoolean)
        {
          if (paramInt != localList.size() - 1) {
            break label159;
          }
          paramBoolean = bool2;
        }
      }
      finally {}
      paramBoolean = bool1;
      continue;
      paramBoolean = bool1;
    }
    for (;;)
    {
      break;
      label159:
      paramBoolean = false;
    }
  }
  
  public boolean isReachOver(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    while ((paramInt & this.nPrivateFlag) != 0)
    {
      return true;
      if (paramBoolean)
      {
        paramInt = 2;
      }
      else
      {
        paramInt = 1;
        continue;
        if (paramBoolean)
        {
          paramInt = 8;
        }
        else
        {
          paramInt = 4;
          continue;
          if (paramBoolean) {
            paramInt = 32;
          } else {
            paramInt = 16;
          }
        }
      }
    }
    return false;
  }
  
  protected void prewrite()
  {
    for (;;)
    {
      synchronized (this.strangerInfos)
      {
        if ((this.nPrivateFlag & 0x8) == 8)
        {
          this.strangerInfosPacked = DatingStranger.a(this.strangerInfos);
          synchronized (this.visitorInfos)
          {
            if ((this.nPrivateFlag & 0x2) == 2) {
              this.visitorInfosPacked = DatingStranger.a(this.visitorInfos);
            }
          }
        }
      }
      synchronized (this.commentList)
      {
        if ((this.nPrivateFlag & 0x8) == 8)
        {
          this.commentPacked = DatingComment.a(this.commentList);
          return;
          this.strangerInfosPacked = "";
          continue;
          localObject1 = finally;
          throw localObject1;
          this.visitorInfosPacked = "";
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        this.commentPacked = "";
      }
    }
  }
  
  public void setReachOver(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramBoolean2)
    {
      this.nPrivateFlag = (paramInt | this.nPrivateFlag);
      return;
      if (paramBoolean1)
      {
        paramInt = 2;
      }
      else
      {
        paramInt = 1;
        continue;
        if (paramBoolean1)
        {
          paramInt = 8;
        }
        else
        {
          paramInt = 4;
          continue;
          if (paramBoolean1) {
            paramInt = 32;
          } else {
            paramInt = 16;
          }
        }
      }
    }
    this.nPrivateFlag = ((paramInt ^ 0xFFFFFFFF) & this.nPrivateFlag);
  }
  
  public boolean updateJoinListData(long paramLong, int paramInt)
  {
    boolean bool3 = false;
    boolean bool2;
    for (boolean bool1 = false;; bool1 = bool2) {
      synchronized (this.strangerInfos)
      {
        Iterator localIterator = this.strangerInfos.iterator();
        DatingStranger localDatingStranger;
        do
        {
          bool2 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
          localDatingStranger = (DatingStranger)localIterator.next();
        } while ((localDatingStranger == null) || (localDatingStranger.a != paramLong));
        if (localDatingStranger.c != paramInt) {
          bool1 = true;
        }
        bool2 = bool1;
        if (bool1)
        {
          localDatingStranger.c = paramInt;
          return bool1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingInfo
 * JD-Core Version:    0.7.0.1
 */