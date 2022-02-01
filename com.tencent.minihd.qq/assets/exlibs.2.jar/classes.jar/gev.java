import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactSearchableDiscussion;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.ContactSearchablePublicAccount;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.ContactSearchableTroop;
import com.tencent.mobileqq.search.ContactsSearchableCircleBuddy;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.search.SearchableDiscussionMember;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class gev
  implements AdapterView.OnItemClickListener
{
  public gev(SearchResultDialog paramSearchResultDialog) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ThreadPriorityManager.a(true);
    Object localObject2 = null;
    if (paramAdapterView == SearchResultDialog.a(this.a)) {
      if (SearchResultDialog.a(this.a) != null) {}
    }
    label1372:
    label3064:
    label3450:
    for (;;)
    {
      return;
      paramAdapterView = (IContactSearchable)SearchResultDialog.a(this.a).getItem(paramInt);
      SearchResultDialog.c(this.a);
      if ((paramAdapterView instanceof ContactSearchableSearchHistory))
      {
        paramView = ((ContactSearchableSearchHistory)paramAdapterView).a();
        if (paramView.type == 56938) {
          if (16 == SearchResultDialog.a(this.a)) {
            this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramView.uin, paramView.type, paramView.displayName, paramView.troopUin);
          }
        }
        Object localObject1;
        Object localObject3;
        for (;;)
        {
          ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Search", "May_find", this.a.b(SearchResultDialog.a(this.a)), 0, "", "", "", "");
          return;
          localObject1 = new ProfileActivity.AllInOne(paramView.uin, 33);
          ((ProfileActivity.AllInOne)localObject1).a = new ArrayList();
          ((ProfileActivity.AllInOne)localObject1).k = paramView.displayName;
          if (!TextUtils.isEmpty(paramView.uin))
          {
            paramView = paramView.uin.split("\\|");
            if (paramView != null)
            {
              paramInt = 0;
              if (paramInt < paramView.length)
              {
                localObject2 = ((ProfileActivity.AllInOne)localObject1).a;
                localObject3 = new StringBuilder().append("电话");
                if (paramView.length > 0) {}
                for (paramAdapterView = Integer.valueOf(paramInt + 1);; paramAdapterView = "")
                {
                  ((ArrayList)localObject2).add(new ProfileActivity.CardContactInfo(paramAdapterView, paramView[paramInt], null));
                  paramInt += 1;
                  break;
                }
              }
            }
          }
          ((ProfileActivity.AllInOne)localObject1).f = 3;
          ProfileActivity.b(SearchResultDialog.a(this.a), (ProfileActivity.AllInOne)localObject1);
          continue;
          if (SearchResultDialog.a(this.a) == 0)
          {
            paramAdapterView = null;
            switch (paramView.type)
            {
            }
            for (;;)
            {
              if (paramAdapterView != null)
              {
                ProfileActivity.b(SearchResultDialog.a(this.a), paramAdapterView);
                this.a.dismiss();
                this.a.a(paramView.displayName, paramView.uin, paramView.troopUin, paramView.type);
                paramAdapterView = (FriendManager)SearchResultDialog.a(this.a).getManager(8);
                if (paramAdapterView == null) {
                  break;
                }
                paramAdapterView = paramAdapterView.c(paramView.uin);
                if ((paramAdapterView == null) || (paramAdapterView.gathtertype != 1)) {
                  break;
                }
                if ((SearchResultDialog.a(this.a) instanceof UncommonlyUsedContactsActivity))
                {
                  ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "0X8004C58", "0X8004C58", 3, 0, "", "", "", "");
                  break;
                  paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 1);
                  continue;
                  paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 31);
                  paramAdapterView.a = new ArrayList();
                  paramAdapterView.k = paramView.displayName;
                  continue;
                  paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 71);
                  paramAdapterView.n = paramView.displayName;
                  continue;
                  paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 71);
                  paramAdapterView.jdField_d_of_type_JavaLangString = paramView.troopUin;
                  continue;
                  paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 47);
                  paramAdapterView.jdField_d_of_type_JavaLangString = paramView.troopUin;
                  continue;
                }
                ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "0X8004C58", "0X8004C58", 1, 0, "", "", "", "");
                break;
              }
            }
            this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramView.uin, paramView.type, paramView.displayName, paramView.troopUin);
          }
          else if (4 == SearchResultDialog.a(this.a))
          {
            this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramView.uin, paramView.type, paramView.displayName, paramView.troopUin);
          }
          else if (16 == SearchResultDialog.a(this.a))
          {
            this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramView.uin, paramView.type, paramView.displayName, paramView.troopUin);
          }
        }
        if (paramAdapterView == SearchResultDialog.b(this.a))
        {
          if (SearchResultDialog.a(this.a) != null) {
            localObject2 = (IContactSearchable)SearchResultDialog.a(this.a).getItem(paramInt);
          }
        }
        else if (localObject2 != null)
        {
          SearchResultDialog.c(this.a);
          if ((12 == SearchResultDialog.a(this.a)) && ((localObject2 instanceof ContactSearchableFriend)))
          {
            paramAdapterView = ((ContactSearchableFriend)localObject2).a();
            if (SearchResultDialog.a(this.a).a(paramAdapterView.uin) != null)
            {
              QQToast.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a).getString(2131369173), 0).b(((BaseActivity)SearchResultDialog.a(this.a)).getTitleBarHeight());
              return;
            }
            paramView = new Intent(SearchResultDialog.a(this.a), QQSpecialFriendSettingActivity.class);
            paramView.putExtra("key_friend_uin", paramAdapterView.uin);
            paramView.putExtra("key_is_from_friendsforward_activity", true);
            if ((SearchResultDialog.a(this.a) instanceof ForwardFriendListActivity)) {
              SearchResultDialog.a(this.a).postDelayed(new gew(this, paramView), 200L);
            }
            for (;;)
            {
              this.a.dismiss();
              return;
              SearchResultDialog.a(this.a).startActivity(paramView);
            }
          }
          if ((SearchResultDialog.a(this.a) == 7) || (SearchResultDialog.a(this.a) == 8) || (SearchResultDialog.a(this.a) == 9) || (SearchResultDialog.a(this.a) == 6) || (SearchResultDialog.a(this.a) == 10) || (SearchResultDialog.a(this.a) == 11) || (SearchResultDialog.a(this.a) == 14))
          {
            paramAdapterView = (TextView)paramView.findViewById(2131297297);
            if (paramAdapterView != null)
            {
              localObject1 = paramAdapterView.getText().toString();
              if (!(localObject2 instanceof ContactSearchableFriend)) {
                break label1372;
              }
              paramView = ((ContactSearchableFriend)localObject2).a().uin;
              paramInt = 0;
              paramAdapterView = paramView;
            }
          }
          for (;;)
          {
            if (StringUtil.b(paramView)) {
              break label3450;
            }
            SearchResultDialog.a(this.a).a(paramView, paramInt, paramAdapterView, (String)localObject1);
            SearchResultDialog.a(SearchResultDialog.a(this.a), SearchResultDialog.b(this.a));
            this.a.a((String)localObject1, paramView, paramAdapterView, paramInt);
            int i = this.a.b(SearchResultDialog.a(this.a));
            ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Search", "Search_into_AIO", i, 0, String.valueOf(this.a.a(paramInt)), String.valueOf(i), "", "");
            if (SearchResultDialog.a(this.a).v == 13) {
              ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Two_call", "Tc_msg_search", 0, 0, "", "", "", "");
            }
            this.a.dismiss();
            return;
            localObject1 = "";
            break;
            if ((localObject2 instanceof ContactSearchableTroop))
            {
              paramView = ((ContactSearchableTroop)localObject2).a().troopuin;
              paramInt = 1;
              paramAdapterView = paramView;
            }
            else if ((localObject2 instanceof ContactSearchableDiscussion))
            {
              paramView = ((ContactSearchableDiscussion)localObject2).a().uin;
              paramInt = 3000;
              paramAdapterView = paramView;
            }
            else if ((localObject2 instanceof ContactsSearchableRecentUser))
            {
              localObject3 = ((ContactsSearchableRecentUser)localObject2).a();
              localObject2 = ((RecentUser)localObject3).uin;
              paramAdapterView = ((RecentUser)localObject3).troopUin;
              paramView = (TextView)paramView.findViewById(16908308);
              if (paramView != null) {
                localObject1 = paramView.getText().toString();
              }
              paramInt = ((RecentUser)localObject3).type;
              paramView = (View)localObject2;
            }
            else
            {
              if ((localObject2 instanceof ContactsSearchablePhoneContact))
              {
                paramAdapterView = ((ContactsSearchablePhoneContact)localObject2).a();
                if (paramAdapterView.uin.equals("0")) {
                  paramView = paramAdapterView.nationCode + paramAdapterView.mobileCode;
                }
                for (paramInt = 1006;; paramInt = 0)
                {
                  paramAdapterView = "";
                  break;
                  paramView = paramAdapterView.uin;
                }
              }
              if ((localObject2 instanceof SearchableDiscussionMember))
              {
                paramAdapterView = (DiscussionMemberInfo)((SearchableDiscussionMember)localObject2).a();
                paramView = paramAdapterView.memberUin;
                paramAdapterView = paramAdapterView.discussionUin;
                paramInt = 1004;
              }
              else if ((localObject2 instanceof ContactsSearchableCircleBuddy))
              {
                paramAdapterView = ((ContactsSearchableCircleBuddy)localObject2).a();
                paramView = paramAdapterView.uin;
                paramAdapterView = paramAdapterView.uin;
                ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Network_circle", "Search_circle_clk", 83, 0, "", "", "", "");
                paramInt = 1021;
                continue;
                SearchResultDialog.c(this.a);
                if ((localObject2 instanceof ContactSearchableFriend))
                {
                  paramAdapterView = ((ContactSearchableFriend)localObject2).a();
                  if (SearchResultDialog.a(this.a) == 16) {
                    this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.uin, 0, ContactUtils.a(paramAdapterView), null);
                  }
                }
                label2557:
                do
                {
                  for (;;)
                  {
                    SearchResultDialog.a(SearchResultDialog.a(this.a), SearchResultDialog.b(this.a));
                    return;
                    this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.uin, 0, ContactUtils.a(paramAdapterView));
                    continue;
                    if ((localObject2 instanceof ContactSearchableTroop))
                    {
                      paramAdapterView = ((ContactSearchableTroop)localObject2).a();
                      if (SearchResultDialog.a(this.a) == 16) {
                        this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.troopuin, 1, paramAdapterView.troopname, paramAdapterView.troopcode);
                      } else {
                        this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.troopuin, 1, paramAdapterView.troopname, paramAdapterView.troopcode);
                      }
                    }
                    else if ((localObject2 instanceof ContactSearchableDiscussion))
                    {
                      paramAdapterView = ((ContactSearchableDiscussion)localObject2).a();
                      if (SearchResultDialog.a(this.a) == 16) {
                        this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.uin, 3000, paramAdapterView.discussionName, null);
                      } else {
                        this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.uin, 3000, paramAdapterView.discussionName);
                      }
                    }
                    else if ((localObject2 instanceof SearchableDiscussionMember))
                    {
                      paramAdapterView = (DiscussionMemberInfo)((SearchableDiscussionMember)localObject2).a();
                      if (SearchResultDialog.a(this.a) == 16) {
                        this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.memberUin, 1004, paramAdapterView.inteRemark, paramAdapterView.discussionUin);
                      } else {
                        this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView.memberUin, 1004, paramAdapterView.inteRemark, paramAdapterView.discussionUin);
                      }
                    }
                    else if ((localObject2 instanceof ContactSearchablePublicAccount))
                    {
                      paramAdapterView = (PublicAccountInfo)((IContactSearchable)localObject2).a();
                      this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), String.valueOf(paramAdapterView.uin), 1008, paramAdapterView.name);
                      this.a.dismiss();
                    }
                    else if ((localObject2 instanceof ContactsSearchableRecentUser))
                    {
                      if (SearchResultDialog.b(this.a) != null)
                      {
                        localObject1 = ((ContactsSearchableRecentUser)localObject2).a;
                        if ((SearchResultDialog.a(this.a) == 16) && (((RecentUser)localObject1).uin != null) && (((RecentUser)localObject1).type != 1008))
                        {
                          this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), String.valueOf(((RecentUser)localObject1).uin), ((RecentUser)localObject1).type, ((ContactsSearchableRecentUser)localObject2).a(), null);
                        }
                        else
                        {
                          com.tencent.mobileqq.activity.recent.RecentUtil.a = true;
                          SearchResultDialog.b(this.a).a(paramAdapterView, paramView, paramInt, paramLong);
                          this.a.dismiss();
                        }
                      }
                    }
                    else
                    {
                      if (!(localObject2 instanceof ContactsSearchablePhoneContact)) {
                        break;
                      }
                      localObject1 = ((ContactsSearchablePhoneContact)localObject2).a();
                      if ((TextUtils.isEmpty(((PhoneContact)localObject1).uin)) || (SearchResultDialog.a(this.a) == 0) || (SearchResultDialog.a(this.a) == 5) || (SearchResultDialog.a(this.a) == 15))
                      {
                        if (TextUtils.isEmpty(((PhoneContact)localObject1).uin))
                        {
                          paramView = new ProfileActivity.AllInOne(((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode, 33);
                          paramView.a = new ArrayList();
                          paramView.k = ((PhoneContact)localObject1).name;
                          paramView.h = ((PhoneContact)localObject1).nickName;
                          localObject2 = ((PhoneContact)localObject1).mobileNo.split("\\|");
                          paramInt = 0;
                          if (paramInt < localObject2.length)
                          {
                            localObject3 = paramView.a;
                            StringBuilder localStringBuilder = new StringBuilder().append("电话");
                            if (localObject2.length > 0) {}
                            for (paramAdapterView = Integer.valueOf(paramInt + 1);; paramAdapterView = "")
                            {
                              ((ArrayList)localObject3).add(new ProfileActivity.CardContactInfo(paramAdapterView, localObject2[paramInt], ((PhoneContact)localObject1).nationCode));
                              paramInt += 1;
                              break;
                            }
                          }
                          paramView.jdField_d_of_type_Int = ((PhoneContact)localObject1).ability;
                          paramView.f = 3;
                          paramAdapterView = paramView;
                          if (!TextUtils.isEmpty(((PhoneContact)localObject1).uin)) {
                            break label2813;
                          }
                          paramView = ((PhoneContact)localObject1).mobileNo;
                          paramInt = 56938;
                        }
                        for (;;)
                        {
                          this.a.a(((PhoneContact)localObject1).name, paramView, "", paramInt);
                          if ((SearchResultDialog.a(this.a) != 16) && (SearchResultDialog.a(this.a) != 5)) {
                            break label2872;
                          }
                          this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramView, paramInt, ((PhoneContact)localObject1).name, null);
                          break;
                          if (!((PhoneContact)localObject1).uin.equals("0"))
                          {
                            paramAdapterView = new ProfileActivity.AllInOne(((PhoneContact)localObject1).uin, 1);
                            break label2557;
                          }
                          paramAdapterView = ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode;
                          if (((PhoneContact)localObject1).originBinder == 3L) {}
                          for (paramInt = 32;; paramInt = 31)
                          {
                            paramAdapterView = new ProfileActivity.AllInOne(paramAdapterView, paramInt);
                            paramAdapterView.a = new ArrayList();
                            paramAdapterView.h = ((PhoneContact)localObject1).nickName;
                            paramAdapterView.k = ((PhoneContact)localObject1).name;
                            paramAdapterView.a.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
                            paramAdapterView.jdField_d_of_type_Int = ((PhoneContact)localObject1).ability;
                            paramAdapterView.f = 3;
                            break;
                          }
                          if (((PhoneContact)localObject1).uin.equals("0"))
                          {
                            paramView = ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode;
                            paramInt = 1006;
                          }
                          else
                          {
                            paramView = ((PhoneContact)localObject1).uin;
                            paramInt = 0;
                          }
                        }
                        ProfileActivity.b(SearchResultDialog.a(this.a), paramAdapterView);
                        if (SearchResultDialog.a(this.a) != 15)
                        {
                          paramInt = this.a.b(SearchResultDialog.a(this.a));
                          ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Search", "Search_into_AIO", paramInt, 0, String.valueOf(this.a.a(1006)), String.valueOf(paramInt), "", "");
                        }
                        this.a.dismiss();
                      }
                      else
                      {
                        if (((PhoneContact)localObject1).uin.equals("0")) {
                          paramAdapterView = ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode;
                        }
                        for (paramInt = 1006;; paramInt = 0)
                        {
                          if (SearchResultDialog.a(this.a) != 16) {
                            break label3064;
                          }
                          this.a.b(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView, paramInt, ((PhoneContact)localObject1).name, null);
                          break;
                          paramAdapterView = ((PhoneContact)localObject1).uin;
                        }
                        this.a.a(SearchResultDialog.a(this.a), SearchResultDialog.a(this.a), paramAdapterView, paramInt, ((PhoneContact)localObject1).name);
                      }
                    }
                  }
                } while (!(localObject2 instanceof ContactsSearchableCircleBuddy));
                label2813:
                paramAdapterView = (CircleBuddy)((IContactSearchable)localObject2).a();
                if (SearchResultDialog.a(this.a) == 4)
                {
                  paramView = new Intent(SearchResultDialog.a(this.a), ChatActivity.class);
                  paramView.putExtra("uin", paramAdapterView.uin);
                  paramView.putExtra("uinname", SearchResultDialog.a(this.a).a(paramAdapterView));
                  paramView.putExtra("uintype", 1021);
                  SearchResultDialog.a(this.a).startActivity(paramView);
                }
                for (i = 1;; i = 0)
                {
                  if (SearchResultDialog.a(this.a) != null) {
                    this.a.a(SearchResultDialog.a(this.a).a(paramAdapterView.uin), paramAdapterView.uin, "", 1021);
                  }
                  if (SearchResultDialog.a(this.a) != 13) {
                    break label3360;
                  }
                  ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "P_prof", "Prof_in_client", 84, 0, "", "", "", "");
                  if ((i != 0) && (SearchResultDialog.b(this.a))) {
                    break;
                  }
                  this.a.dismiss();
                  break;
                  paramView = new ProfileActivity.AllInOne(paramAdapterView.uin, 71);
                  paramView.n = paramAdapterView.remark;
                  paramView.h = paramAdapterView.nickName;
                  paramView.g = 84;
                  ProfileActivity.b(SearchResultDialog.a(this.a), paramView);
                }
                paramInt = 0;
                switch (SearchResultDialog.a(this.a))
                {
                }
                for (;;)
                {
                  ReportController.b(SearchResultDialog.a(this.a), "CliOper", "", "", "Network_circle", "Search_circle_clk", paramInt, 0, "", "", "", "");
                  break;
                  paramInt = 81;
                  continue;
                  paramInt = 59;
                }
              }
              else
              {
                paramInt = -1;
                paramAdapterView = null;
                paramView = null;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gev
 * JD-Core Version:    0.7.0.1
 */