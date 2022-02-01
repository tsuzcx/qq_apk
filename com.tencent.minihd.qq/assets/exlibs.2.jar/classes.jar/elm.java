import EncounterSvc.NeighborBanner;
import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;

public class elm
  implements View.OnClickListener
{
  public elm(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (PeopleAroundAdapter.ViewHolder)paramView.getTag();
    if ((paramView != null) && (paramView.a != null))
    {
      paramView = paramView.a;
      if (!(paramView instanceof NeighborBanner)) {
        break label146;
      }
      paramView = new String(((NeighborBanner)paramView).skip_url);
      this.a.b("0X80050D3");
      if (!TextUtils.isEmpty(paramView))
      {
        localObject1 = JumpParser.a(this.a.app, this.a, paramView);
        if (localObject1 == null) {
          break label110;
        }
        ((JumpAction)localObject1).b();
      }
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.b(9);
      }
      return;
      label110:
      localObject1 = new Intent(this.a, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", URLUtil.guessUrl(paramView));
      this.a.startActivity((Intent)localObject1);
    }
    label146:
    paramView = (RespEncounterInfo)paramView;
    Object localObject1 = String.valueOf(paramView.lEctID);
    Object localObject2 = (FriendManager)this.a.app.getManager(8);
    if ((paramView.lEctID > 0L) && (localObject2 != null)) {}
    for (boolean bool = ((FriendManager)localObject2).b((String)localObject1);; bool = false)
    {
      if (((String)localObject1).equals(this.a.app.a())) {
        if ((this.a.getIntent() == null) || (this.a.getIntent().getIntExtra("FROM_WHERE", -1) != 0) || (!this.a.getIntent().getBooleanExtra("IS_HAS_REDTOUCH", false))) {
          break label875;
        }
      }
      label525:
      label875:
      for (bool = true;; bool = false)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 0);
        ((ProfileActivity.AllInOne)localObject1).h = paramView.strNick;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramView.cAge;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramView.cSex;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramView.wFace;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Byte = paramView.marriage;
        ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_Int = paramView.profession_id;
        ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_Byte = paramView.constellation;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_ArrayOfByte = paramView.richState.vState;
        ((ProfileActivity.AllInOne)localObject1).f = this.a.s;
        ((ProfileActivity.AllInOne)localObject1).g = 5;
        localObject2 = new Intent(this.a, NearbyPeopleProfileActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("param_mode", 2);
        ((Intent)localObject2).putExtra("param_tiny_id", paramView.tiny_id);
        ((Intent)localObject2).putExtra("IS_NEARBY_REDDOT_INCOME", bool);
        this.a.startActivityForResult((Intent)localObject2, 1000);
        this.a.a("0X800482F", "1", "", "", "");
        if (paramView.iVoteIncrement > 0) {
          if (!bool) {
            break label525;
          }
        }
        for (paramView = "1";; paramView = "")
        {
          this.a.a("0X8004ED8", paramView, "", "", "");
          if ((NearbyActivity.a(this.a) != null) && (NearbyActivity.a(this.a).a != null)) {
            NearbyActivity.a(this.a).a.b = true;
          }
          if (this.a.a == null) {
            break;
          }
          this.a.a.b(0);
          return;
        }
        if (bool)
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 40);
          ((ProfileActivity.AllInOne)localObject1).h = paramView.strNick;
          ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramView.cAge;
          ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramView.cSex;
          ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramView.wFace;
          ((ProfileActivity.AllInOne)localObject1).f = this.a.s;
          ((ProfileActivity.AllInOne)localObject1).g = 5;
          ProfileActivity.b(this.a, (ProfileActivity.AllInOne)localObject1);
          if (this.a.a == null) {
            break;
          }
          this.a.a.b(1);
          return;
        }
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 41);
        ((ProfileActivity.AllInOne)localObject1).h = paramView.strNick;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramView.cAge;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramView.cSex;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramView.wFace;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Byte = paramView.marriage;
        ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_Int = paramView.profession_id;
        ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_Byte = paramView.constellation;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_ArrayOfByte = paramView.richState.vState;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_JavaLangString = paramView.strDescription;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_ArrayOfByte = paramView.sig;
        ((ProfileActivity.AllInOne)localObject1).o = paramView.enc_id;
        ((ProfileActivity.AllInOne)localObject1).p = paramView.uid;
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby", 4, "附近人列表accost_uin = " + ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_JavaLangString + "accost_sig = " + ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_ArrayOfByte);
        }
        ((ProfileActivity.AllInOne)localObject1).f = this.a.s;
        ((ProfileActivity.AllInOne)localObject1).g = 5;
        localObject2 = new Intent(this.a, NearbyPeopleProfileActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("param_mode", 3);
        ((Intent)localObject2).putExtra("param_tiny_id", paramView.tiny_id);
        this.a.startActivity((Intent)localObject2);
        if (this.a.a == null) {
          break;
        }
        this.a.a.b(1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elm
 * JD-Core Version:    0.7.0.1
 */