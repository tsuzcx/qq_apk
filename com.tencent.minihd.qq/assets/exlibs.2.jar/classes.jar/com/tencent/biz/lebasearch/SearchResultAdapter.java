package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import chj;
import chk;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchResultAdapter
  extends BaseAdapter
{
  public static final String a = "SearchResultAdapter";
  public static final String b = "leba_search";
  public static final String c = "leba_search_plugin_load";
  public static final String d = "leba_search_load_fail";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new chj(this);
  private SearchResultAdapter.OnResultItemClickedListener jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter$OnResultItemClickedListener;
  private ViewPluginManager jdField_a_of_type_ComTencentBizViewpluginViewPluginManager;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  JSONArray jdField_a_of_type_OrgJsonJSONArray;
  
  public SearchResultAdapter(Context paramContext, ViewPluginManager paramViewPluginManager, JSONArray paramJSONArray, SearchResultAdapter.OnResultItemClickedListener paramOnResultItemClickedListener)
  {
    a(paramJSONArray);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = paramViewPluginManager;
    this.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter$OnResultItemClickedListener = paramOnResultItemClickedListener;
  }
  
  public static SpannableString a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 == null) {
      return new SpannableString(paramString1);
    }
    int i = paramString1.indexOf(paramString2);
    if (i != -1)
    {
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), i, paramString2.length() + i, 34);
      return paramString1;
    }
    return new SpannableString(paramString1);
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    if (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
    {
      paramJSONArray = this.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(i);
      chk localchk = new chk(this);
      localchk.e = 1;
      if (paramJSONArray.has("result_name"))
      {
        localchk.jdField_a_of_type_JavaLangObject = paramJSONArray.optString("result_name");
        localchk.jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
      }
      Object localObject;
      if (paramJSONArray.has("result_extension"))
      {
        localObject = paramJSONArray.optJSONArray("result_extension");
        if (((JSONArray)localObject).length() != 0) {}
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilList.add(localchk);
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          localchk = new chk(this);
          localchk.e = 2;
          localchk.jdField_a_of_type_JavaLangObject = ((JSONArray)localObject).optJSONObject(j);
          localchk.jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
          this.jdField_a_of_type_JavaUtilList.add(localchk);
          if (j != ((JSONArray)localObject).length() - 1)
          {
            localchk = new chk(this);
            localchk.e = 4;
            this.jdField_a_of_type_JavaUtilList.add(localchk);
          }
          j += 1;
        }
        if ((paramJSONArray.has("more_url")) && (!TextUtils.isEmpty(paramJSONArray.optString("more_url"))))
        {
          localObject = new chk(this);
          ((chk)localObject).e = 4;
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          localObject = new chk(this);
          ((chk)localObject).e = 3;
          ((chk)localObject).jdField_a_of_type_JavaLangObject = paramJSONArray.optString("more_url");
          ((chk)localObject).jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
          ((chk)localObject).b = paramJSONArray.optString("more_name");
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
      }
    }
    paramJSONArray = new chk(this);
    paramJSONArray.e = 4;
    this.jdField_a_of_type_JavaUtilList.add(paramJSONArray);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return null;
    }
    Object localObject3 = (BaseActivity)localObject2;
    chk localchk = (chk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localchk.e == 1)
    {
      paramView = new TextView((Context)localObject2);
      paramView.setBackgroundColor(((Context)localObject2).getResources().getColor(2131427760));
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)DisplayUtils.a((Context)localObject2, 23.0F)));
      paramView.setTextColor(((Context)localObject2).getResources().getColor(2131427488));
      paramView.setTextSize(14.0F);
      paramView.setPadding((int)DisplayUtils.a((Context)localObject2, 15.0F), 0, 0, 0);
      paramView.setText((String)localchk.jdField_a_of_type_JavaLangObject);
      paramView.setGravity(16);
      paramView.setFocusable(true);
      return paramView;
    }
    if (localchk.e == 2)
    {
      Object localObject1 = (JSONObject)localchk.jdField_a_of_type_JavaLangObject;
      paramViewGroup = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(((JSONObject)localObject1).optInt("result_type"));
      if (paramViewGroup != null) {
        if (ViewPluginManager.a(paramViewGroup, ((JSONObject)localObject1).toString())) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        paramViewGroup.setTag(localchk);
        paramView = paramViewGroup;
        if (paramInt == 0)
        {
          paramView = LayoutInflater.from((Context)localObject2).inflate(2130903489, null);
          paramViewGroup = (ImageView)paramView.findViewById(2131298500);
          localObject2 = (TextView)paramView.findViewById(2131298501);
          localObject3 = a(((JSONObject)localObject1).optString("name"), ((JSONObject)localObject1).optString("keyword"));
          if (localObject3 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject3);
          }
        }
        try
        {
          new URL(((JSONObject)localObject1).optString("pic_url"));
          localObject1 = URLDrawable.getDrawable(((JSONObject)localObject1).optString("pic_url"));
          ((URLDrawable)localObject1).addHeader("User-Agent", "Dalvik/1.6.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + ")");
          paramViewGroup.setImageDrawable((Drawable)localObject1);
          paramView.setTag(localchk);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
          ReportController.b(((BaseActivity)localObject3).app, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_load_fail", 0, 0, HtmlOffline.c("1002"), "2", null, null);
          paramInt = 0;
          continue;
          ReportController.b(((BaseActivity)localObject3).app, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_load_fail", 0, 0, HtmlOffline.c("1002"), "1", null, null);
          paramInt = 0;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            paramViewGroup.setBackgroundColor(Color.parseColor("#e7e7e7"));
            if (QLog.isColorLevel()) {
              QLog.d("SearchResultAdapter", 2, localMalformedURLException.getMessage());
            }
          }
        }
      }
    }
    if (localchk.e == 3)
    {
      paramView = LayoutInflater.from((Context)localObject2).inflate(2130903488, null);
      paramViewGroup = new AbsListView.LayoutParams(-1, (int)DisplayUtils.a((Context)localObject2, 44.0F));
      TextView localTextView = (TextView)paramView.findViewById(2131298499);
      if (!TextUtils.isEmpty(localchk.b)) {
        localTextView.setText(localchk.b);
      }
      paramView.setLayoutParams(paramViewGroup);
      paramView.setTag(localchk);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
    }
    if (localchk.e == 4)
    {
      paramView = new TextView((Context)localObject2);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      paramView.setBackgroundColor(Color.parseColor("#dedfe0"));
      return paramView;
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */