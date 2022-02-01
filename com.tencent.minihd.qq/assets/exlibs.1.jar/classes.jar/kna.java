import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class kna
  implements AdapterView.OnItemClickListener
{
  public kna(AvatarWallAdapter paramAvatarWallAdapter) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1;
    Bundle localBundle;
    if ((this.a.jdField_a_of_type_MqqUtilWeakReference != null) && (this.a.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      paramView = (Activity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      localObject1 = this.a.a(paramInt);
      if (localObject1 != null)
      {
        if (((AvatarWallAdapter.AvatarInfo)localObject1).c.equals("PLUS")) {
          break label412;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(paramView, TroopAvatarWallPreviewActivity.class);
        localBundle = new Bundle();
        Object localObject2 = new ArrayList();
        int i = 0;
        while (i < this.a.b)
        {
          new Rect();
          Rect localRect = AnimationUtils.a(paramAdapterView.getChildAt(i));
          if (localRect != null) {
            ((ArrayList)localObject2).add(localRect);
          }
          i += 1;
        }
        if (((ArrayList)localObject2).size() > 0) {
          ((Intent)localObject1).putParcelableArrayListExtra("KEY_THUMBNAL_BOUND", (ArrayList)localObject2);
        }
        localBundle.putInt("index", paramInt);
        paramAdapterView = new ArrayList();
        paramInt = 0;
        if (paramInt < this.a.b)
        {
          localObject2 = this.a.a(paramInt);
          if (((((AvatarWallAdapter.AvatarInfo)localObject2).c == "AVATAR_URL_STR") || (((AvatarWallAdapter.AvatarInfo)localObject2).c == "SYSTEM_PHOTO")) && (((AvatarWallAdapter.AvatarInfo)localObject2).a == null) && (((AvatarWallAdapter.AvatarInfo)localObject2).b != null)) {
            paramAdapterView.add(((AvatarWallAdapter.AvatarInfo)localObject2).b);
          }
          for (;;)
          {
            paramInt += 1;
            break;
            if (((AvatarWallAdapter.AvatarInfo)localObject2).a != null) {
              paramAdapterView.add(((AvatarWallAdapter.AvatarInfo)localObject2).a);
            }
          }
        }
        if (paramAdapterView.size() != 0) {
          break label296;
        }
      }
    }
    return;
    label296:
    localBundle.putBoolean("IS_EDIT", this.a.c);
    localBundle.putStringArrayList("seqNum", paramAdapterView);
    localBundle.putString("troop_uin", this.a.g);
    localBundle.putBoolean("troop_info_is_member", this.a.e);
    ((Intent)localObject1).putExtras(localBundle);
    ((Intent)localObject1).putExtra("is_activity_to_fragment", false);
    paramView.startActivityForResult((Intent)localObject1, 14);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.a.h, "nonmber_Clk_head", 0, 0, this.a.g, "", "", "");
    return;
    label412:
    if (this.a.jdField_a_of_type_ArrayOfInt == null) {
      this.a.jdField_a_of_type_ArrayOfInt = new int[AvatarWallAdapter.q];
    }
    this.a.jdField_a_of_type_ArrayOfInt[0] = 13;
    this.a.jdField_a_of_type_ArrayOfInt[1] = 14;
    this.a.jdField_a_of_type_ArrayOfInt[2] = 16;
    paramInt = 3;
    while (paramInt < AvatarWallAdapter.q)
    {
      this.a.jdField_a_of_type_ArrayOfInt[paramInt] = -1;
      paramInt += 1;
    }
    this.a.a(this.a.jdField_a_of_type_ArrayOfInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kna
 * JD-Core Version:    0.7.0.1
 */