package com.tencent.mm.plugin.exdevice.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "appName", "", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "profileData", "Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;", "getProfileData", "()Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;", "setProfileData", "(Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;)V", "rankId", "getRankId", "setRankId", "inflateItemView", "Landroid/view/View;", "viewType", "", "updateItemView", "", "itemView", "username", "OtherBtnViewHolder", "ProfileViewHolder", "app_release"})
public final class SportProfileUIC
  extends UIComponent
{
  String appName;
  String rCB;
  public bxc rMR;
  
  public SportProfileUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(230647);
    AppMethodBeat.o(230647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportProfileUIC
 * JD-Core Version:    0.7.0.1
 */