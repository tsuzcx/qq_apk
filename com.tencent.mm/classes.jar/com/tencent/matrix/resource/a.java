package com.tencent.matrix.resource;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class a
{
  static void bJ(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (paramView.getContext() == null) {
        continue;
      }
      if (paramView != null) {}
      try
      {
        paramView.setOnClickListener(null);
      }
      catch (Throwable localThrowable15)
      {
        try
        {
          label21:
          paramView.setOnCreateContextMenuListener(null);
        }
        catch (Throwable localThrowable15)
        {
          try
          {
            label26:
            paramView.setOnFocusChangeListener(null);
          }
          catch (Throwable localThrowable15)
          {
            try
            {
              label31:
              paramView.setOnKeyListener(null);
            }
            catch (Throwable localThrowable15)
            {
              try
              {
                label36:
                paramView.setOnLongClickListener(null);
              }
              catch (Throwable localThrowable15)
              {
                try
                {
                  label41:
                  paramView.setOnClickListener(null);
                }
                catch (Throwable localThrowable15)
                {
                  try
                  {
                    label46:
                    paramView.setOnTouchListener(null);
                    label51:
                    if (paramView.getBackground() == null) {}
                  }
                  catch (Throwable localThrowable15)
                  {
                    try
                    {
                      paramView.getBackground().setCallback(null);
                      paramView.setBackgroundDrawable(null);
                      try
                      {
                        label71:
                        paramView.destroyDrawingCache();
                        label75:
                        if ((paramView instanceof ImageView))
                        {
                          localObject1 = (ImageView)paramView;
                          if (localObject1 != null)
                          {
                            localObject3 = ((ImageView)localObject1).getDrawable();
                            if (localObject3 != null) {
                              ((Drawable)localObject3).setCallback(null);
                            }
                            ((ImageView)localObject1).setImageDrawable(null);
                          }
                        }
                        if ((paramView instanceof TextView))
                        {
                          localObject1 = (TextView)paramView;
                          localObject3 = ((TextView)localObject1).getCompoundDrawables();
                          j = localObject3.length;
                          i = 0;
                          while (i < j)
                          {
                            Object localObject4 = localObject3[i];
                            if (localObject4 != null) {
                              localObject4.setCallback(null);
                            }
                            i += 1;
                          }
                          ((TextView)localObject1).setCompoundDrawables(null, null, null, null);
                          ((TextView)localObject1).setOnEditorActionListener(null);
                          ((TextView)localObject1).setKeyListener(null);
                          ((TextView)localObject1).setMovementMethod(null);
                          if ((!(localObject1 instanceof EditText)) || (localObject1 == null)) {}
                        }
                      }
                      catch (Throwable localThrowable15)
                      {
                        try
                        {
                          int j;
                          int i;
                          ((TextView)localObject1).setHint("");
                          Object localObject3 = TextView.class.getDeclaredField("mListeners");
                          ((Field)localObject3).setAccessible(true);
                          Object localObject1 = ((Field)localObject3).get(localObject1);
                          if ((localObject1 instanceof ArrayList)) {
                            ((ArrayList)localObject1).clear();
                          }
                          label242:
                          if ((paramView instanceof ProgressBar))
                          {
                            localObject1 = (ProgressBar)paramView;
                            localObject3 = ((ProgressBar)localObject1).getProgressDrawable();
                            if (localObject3 != null)
                            {
                              ((ProgressBar)localObject1).setProgressDrawable(null);
                              ((Drawable)localObject3).setCallback(null);
                            }
                            localObject3 = ((ProgressBar)localObject1).getIndeterminateDrawable();
                            if (localObject3 != null)
                            {
                              ((ProgressBar)localObject1).setIndeterminateDrawable(null);
                              ((Drawable)localObject3).setCallback(null);
                            }
                          }
                          if ((paramView instanceof ListView))
                          {
                            localObject1 = (ListView)paramView;
                            localObject3 = ((ListView)localObject1).getSelector();
                            if (localObject3 != null) {
                              ((Drawable)localObject3).setCallback(null);
                            }
                          }
                          try
                          {
                            if (((ListView)localObject1).getAdapter() != null) {
                              ((ListView)localObject1).setAdapter(null);
                            }
                            try
                            {
                              label339:
                              ((ListView)localObject1).setOnScrollListener(null);
                            }
                            catch (Throwable localThrowable15)
                            {
                              try
                              {
                                ((ListView)localObject1).setOnItemClickListener(null);
                              }
                              catch (Throwable localThrowable15)
                              {
                                try
                                {
                                  ((ListView)localObject1).setOnItemLongClickListener(null);
                                }
                                catch (Throwable localThrowable15)
                                {
                                  try
                                  {
                                    for (;;)
                                    {
                                      ((ListView)localObject1).setOnItemSelectedListener(null);
                                      label359:
                                      if ((paramView instanceof FrameLayout))
                                      {
                                        localObject1 = (FrameLayout)paramView;
                                        if (localObject1 != null)
                                        {
                                          localObject3 = ((FrameLayout)localObject1).getForeground();
                                          if (localObject3 != null)
                                          {
                                            ((Drawable)localObject3).setCallback(null);
                                            ((FrameLayout)localObject1).setForeground(null);
                                          }
                                        }
                                      }
                                      if ((paramView instanceof LinearLayout))
                                      {
                                        localObject3 = (LinearLayout)paramView;
                                        if ((localObject3 != null) && (11 <= Build.VERSION.SDK_INT))
                                        {
                                          if (16 > Build.VERSION.SDK_INT) {
                                            break label491;
                                          }
                                          localObject1 = ((LinearLayout)localObject3).getDividerDrawable();
                                        }
                                      }
                                      for (;;)
                                      {
                                        if (localObject1 != null)
                                        {
                                          ((Drawable)localObject1).setCallback(null);
                                          ((LinearLayout)localObject3).setDividerDrawable(null);
                                        }
                                        if (!(paramView instanceof ViewGroup)) {
                                          break;
                                        }
                                        paramView = (ViewGroup)paramView;
                                        j = paramView.getChildCount();
                                        i = 0;
                                        while (i < j)
                                        {
                                          bJ(paramView.getChildAt(i));
                                          i += 1;
                                        }
                                        try
                                        {
                                          label491:
                                          localObject1 = localObject3.getClass().getDeclaredField("mDivider");
                                          ((Field)localObject1).setAccessible(true);
                                          localObject1 = (Drawable)((Field)localObject1).get(localObject3);
                                        }
                                        catch (Throwable localThrowable1)
                                        {
                                          Object localObject2 = null;
                                        }
                                      }
                                      localThrowable2 = localThrowable2;
                                      break label21;
                                      localThrowable3 = localThrowable3;
                                      break label26;
                                      localThrowable4 = localThrowable4;
                                      break label31;
                                      localThrowable5 = localThrowable5;
                                      break label36;
                                      localThrowable6 = localThrowable6;
                                      break label41;
                                      localThrowable7 = localThrowable7;
                                      break label46;
                                      localThrowable8 = localThrowable8;
                                      break label51;
                                      localThrowable9 = localThrowable9;
                                      break label75;
                                      localThrowable13 = localThrowable13;
                                      continue;
                                      localThrowable14 = localThrowable14;
                                      continue;
                                      localThrowable15 = localThrowable15;
                                    }
                                  }
                                  catch (Throwable localThrowable10)
                                  {
                                    break label359;
                                  }
                                }
                              }
                            }
                          }
                          catch (Throwable localThrowable16)
                          {
                            break label339;
                          }
                        }
                        catch (Throwable localThrowable11)
                        {
                          break label242;
                        }
                      }
                    }
                    catch (Throwable localThrowable12)
                    {
                      break label71;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.a
 * JD-Core Version:    0.7.0.1
 */