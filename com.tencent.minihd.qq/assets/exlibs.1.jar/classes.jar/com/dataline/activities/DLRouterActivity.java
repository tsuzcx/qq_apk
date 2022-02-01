package com.dataline.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XListView;
import h;
import i;
import j;
import k;
import l;
import m;
import o;

public class DLRouterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static String a;
  private final View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new k(this);
  public ViewGroup a;
  private final AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new l(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public ScrollerRunnable a;
  public XListView a;
  private m jdField_a_of_type_M;
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  private String c;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.DLRouterActivity";
  }
  
  public DLRouterActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = null;
  }
  
  private void a(boolean paramBoolean)
  {
    new Handler().postDelayed(new j(this, paramBoolean), 0L);
  }
  
  void a(Intent paramIntent)
  {
    if (55 == paramIntent.getIntExtra(AlbumConstants.i, -1))
    {
      paramIntent.removeExtra(AlbumConstants.i);
      DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.app.a(53)).a(Long.parseLong(this.b));
      if ((localDeviceInfo == null) || (localDeviceInfo.userStatus == 20)) {
        break label129;
      }
      new o(this, null).execute(new Intent[] { paramIntent });
    }
    for (;;)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
        this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isBack2Root", false);
      }
      if (this.leftView.getText().toString().equals(getString(2131366036))) {
        this.jdField_a_of_type_Boolean = false;
      }
      return;
      label129:
      FMToastUtil.a(2131362207);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("unbind_flag", false)));
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Intent localIntent = getIntent();
    this.b = localIntent.getStringExtra("uin");
    this.d = localIntent.getStringExtra("uinname");
    this.c = localIntent.getStringExtra("account");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "din:" + this.b);
    }
    getWindow().setBackgroundDrawableResource(2131427366);
    setContentView(2130903245);
    setTitle(this.d);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)findViewById(2131297458));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296424, "n/a");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297459));
    paramBundle = getResources().getDrawable(2130841864);
    if ((paramBundle instanceof BitmapDrawable)) {
      paramBundle = ((BitmapDrawable)paramBundle).getBitmap();
    }
    for (;;)
    {
      paramBundle = new BitmapDrawable(paramBundle);
      if (paramBundle != null)
      {
        paramBundle.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBundle.setDither(true);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(paramBundle);
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131297460));
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_M = new m(this, null);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_M);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297398));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131297397));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297030));
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-5855578);
      this.jdField_a_of_type_AndroidWidgetEditText.setText("暂不支持文字消息");
      this.jdField_a_of_type_AndroidWidgetEditText.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      a(true);
      this.rightViewImg.setImageResource(2130841829);
      this.rightViewImg.setContentDescription(getResources().getText(2131362064));
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(new h(this));
      paramBundle = (RouterHandler)this.app.a(50);
      paramBundle.a(this.b);
      paramBundle.a = new RouterSessionAdapter(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297394));
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramBundle.a);
      View localView = LayoutInflater.from(getActivity()).inflate(2130903177, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getActivity().getResources().getDrawable(2130840064));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(localView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new i(this));
      a(localIntent);
      paramBundle.a.notifyDataSetChanged();
      return true;
      if ((paramBundle instanceof SkinnableBitmapDrawable)) {
        paramBundle = ((SkinnableBitmapDrawable)paramBundle).getBitmap();
      } else {
        paramBundle = null;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    RouterHandler localRouterHandler = (RouterHandler)this.app.a(50);
    localRouterHandler.a = null;
    localRouterHandler.b(this.b);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    ((SmartDeviceProxyMgr)this.app.a(53)).d();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", 1);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297397) {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8) {
        break label30;
      }
    }
    label30:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.DLRouterActivity
 * JD-Core Version:    0.7.0.1
 */