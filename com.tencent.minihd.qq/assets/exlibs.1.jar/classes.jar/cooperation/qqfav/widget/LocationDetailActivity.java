package cooperation.qqfav.widget;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import lzn;
import lzo;
import lzp;
import lzq;

public class LocationDetailActivity
  extends PoiMapActivity
{
  public static final int D = 13321;
  public static final int E = 13322;
  public static final String u = "forNewFavorite";
  public long a;
  private FadeIconImageView jdField_a_of_type_ComTencentWidgetFadeIconImageView = null;
  private FavoriteActionSheet jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet = null;
  public ImageView g;
  public TextView g;
  private boolean u = false;
  public String v;
  public String w;
  public String x;
  public String y = null;
  
  public LocationDetailActivity()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_g_of_type_AndroidWidgetTextView = null;
    this.jdField_g_of_type_AndroidWidgetImageView = null;
  }
  
  private void y()
  {
    if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968702);
      localAnimation.setAnimationListener(new lzn(this));
      this.jdField_g_of_type_AndroidWidgetTextView.startAnimation(localAnimation);
      return;
    }
    if (TextUtils.isEmpty(this.y))
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    if (VersionUtils.e()) {
      this.jdField_g_of_type_AndroidWidgetTextView.setAlpha(0.9F);
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setText(new QQText(this.y, 3, 22));
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = b(this);
    Intent localIntent = new Intent(c(this));
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("modify", paramBoolean);
    localIntent.putExtra("favId", this.jdField_a_of_type_Long);
    localIntent.putExtra("note", this.y);
    localIntent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = localIntent.getStringExtra("pluginsdk_selfuin");
    if (paramBoolean) {}
    for (int i = 13322;; i = 13321)
    {
      QfavHelper.a(this, (String)localObject, localIntent, i);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 103) || (paramIntent == null)) {
        break label197;
      }
      Intent localIntent = super.a();
      localIntent.setClass(this, ChatActivity.class);
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("forward_latitude", localIntent.getStringExtra("latitude")).putExtra("forward_longitude", localIntent.getStringExtra("longitude")).putExtra("forward_location", localIntent.getStringExtra("description")).putExtra("forward_location_string", localIntent.getStringExtra("description")).putExtra("forward_thumb", AppConstants.bu + this.v + "_" + this.w + ".png").putExtra("isFromFavorites", true).putExtra("title", this.n).putExtra("summary", this.jdField_o_of_type_JavaLangString);
      super.startActivity(localIntent);
      super.finish();
    }
    for (;;)
    {
      if ((this.jdField_g_of_type_AndroidWidgetImageView != null) && (13322 != paramInt1)) {
        this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      return;
      label197:
      if (13321 == paramInt1)
      {
        super.finish();
      }
      else if ((13322 == paramInt1) && (paramIntent != null))
      {
        this.y = paramIntent.getStringExtra("note");
        y();
      }
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(0, new Intent());
    if (this.jdField_g_of_type_AndroidWidgetImageView != null) {
      this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(null);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    y();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet != null) && (this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet.a())) {
      this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet.a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299257));
    this.y = super.getIntent().getStringExtra("note");
    this.jdField_o_of_type_Boolean = true;
    if (this.l != null) {
      this.l.setVisibility(8);
    }
    y();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet != null)
    {
      if (this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet.a()) {
        this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet.b();
      }
      this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet = null;
    }
  }
  
  public void onStart()
  {
    super.overridePendingTransition(0, 0);
    super.onStart();
  }
  
  protected void s()
  {
    Bundle localBundle = super.getIntent().getExtras();
    this.x = localBundle.getString("loc");
    this.v = localBundle.getString("lat");
    this.w = localBundle.getString("lon");
    this.jdField_a_of_type_Long = localBundle.getLong("favId");
    TextView localTextView1 = (TextView)findViewById(2131297357);
    localTextView1.setText(2131364623);
    localTextView1.setOnClickListener(new lzo(this));
    ((TextView)super.findViewById(2131297348)).setText(2131364673);
    TextView localTextView2 = (TextView)super.findViewById(2131297360);
    if (!localBundle.getBoolean("forNewFavorite", false))
    {
      this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet = new lzp(this, this, new LocationDetailActivity.LocationActions(this), 1, 7, null);
      localTextView1.setText(localBundle.getString("leftViewText"));
      localTextView2.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297361));
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130838415);
      this.jdField_g_of_type_AndroidWidgetImageView.setContentDescription(super.getString(2131366569));
      this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131297362));
      if (!QfavUtil.a()) {
        if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
          this.u = true;
        }
      }
    }
    for (;;)
    {
      localTextView2.setTag(localTextView2.getText());
      return;
      if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
        continue;
        localTextView1.setText(2131365114);
        localTextView2.setText(2131367271);
        localTextView2.setOnClickListener(new lzq(this));
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    if (super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      super.setContentView(paramInt);
      return;
    }
    super.setContentView(2130903719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */