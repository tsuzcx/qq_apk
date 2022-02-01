package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class ContactFacade
  implements Manager
{
  public static final String a = "Q.contacttab.ContactFacade";
  private DiscussionManager jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private PublicAccountDataManager jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  private FetchBuddyAndTroopNameHelper jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper;
  public Object a;
  
  public ContactFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(49));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)paramQQAppInterface.getManager(54));
  }
  
  public FetchBuddyAndTroopNameHelper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper = new FetchBuddyAndTroopNameHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper;
    }
  }
  
  public ArrayList a(String paramString)
  {
    if (paramString.equalsIgnoreCase("-1004")) {
      return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a();
    }
    if (paramString.equalsIgnoreCase("-1006")) {
      return this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a();
    }
    if (paramString.equalsIgnoreCase("-1003")) {
      return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("preloadFriends");
    TraceUtils.a("splitRecents");
    ArrayList localArrayList1 = new ArrayList(4);
    ArrayList localArrayList2 = new ArrayList(4);
    ArrayList localArrayList3 = new ArrayList(4);
    localArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      switch (localRecentUser.type)
      {
      default: 
        break;
      case 0: 
        localArrayList1.add(localRecentUser.uin);
        break;
      case 1: 
        localArrayList2.add(localRecentUser.uin);
        break;
      case 3000: 
        localArrayList3.add(localRecentUser.uin);
      }
    }
    TraceUtils.a();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localArrayList1);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(localArrayList2);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(localArrayList3);
    TraceUtils.a();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ContactFacade
 * JD-Core Version:    0.7.0.1
 */