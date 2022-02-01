package com.tencent.mobileqq.facetoface;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import ijg;
import java.util.ArrayList;
import java.util.List;

public class Face2FaceTroopFriendListAdapter
  extends FacePreloadBaseAdapter
{
  private List a = null;
  
  public Face2FaceTroopFriendListAdapter(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public Face2FaceUserProfile a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (Face2FaceUserProfile)this.a.get(paramInt);
    }
    return null;
  }
  
  protected Object a(int paramInt)
  {
    return null;
  }
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile)
  {
    if (getCount() == 0) {
      this.a = new ArrayList();
    }
    this.a.add(0, paramFace2FaceUserProfile);
    notifyDataSetChanged();
  }
  
  public void a(List paramList)
  {
    this.a = new ArrayList(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.a != null) {
      return this.a.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l2 = System.currentTimeMillis();
    View localView;
    long l1;
    Face2FaceUserProfile localFace2FaceUserProfile;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2130903312, null);
      paramViewGroup = new ijg();
      paramViewGroup.d = ((ImageView)localView.findViewById(2131297636));
      paramViewGroup.a = ((TextView)localView.findViewById(2131297641));
      localView.setTag(paramViewGroup);
      l1 = System.currentTimeMillis();
      localFace2FaceUserProfile = a(paramInt);
      paramViewGroup.b = localFace2FaceUserProfile.e;
      if (localFace2FaceUserProfile == null) {
        break label236;
      }
      paramViewGroup.d.setImageBitmap(a(1, localFace2FaceUserProfile.e));
      long l3 = System.currentTimeMillis();
      str = localFace2FaceUserProfile.a;
      if (str != null) {
        break label213;
      }
      paramView = localFace2FaceUserProfile.e;
      label131:
      paramViewGroup.a.setText(paramView);
      l1 = l3 - l1;
    }
    label213:
    label236:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l2) + ", faceBitmap = " + l1);
      }
      return localView;
      paramViewGroup = (ijg)paramView.getTag();
      localView = paramView;
      break;
      paramView = str;
      if (!TextUtils.isEmpty(str.trim())) {
        break label131;
      }
      paramView = localFace2FaceUserProfile.e;
      break label131;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopFriendListAdapter
 * JD-Core Version:    0.7.0.1
 */